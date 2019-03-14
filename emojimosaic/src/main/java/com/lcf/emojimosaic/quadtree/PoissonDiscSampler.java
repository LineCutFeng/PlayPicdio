package com.lcf.emojimosaic.quadtree;

public class PoissonDiscSampler {

    private Point[][] mPoints;
    private int mWidth;
    private int mHeight;
    private int mNumCandidates = 10;
    private QuadTree mQuadTree;

    public PoissonDiscSampler(QuadTree quadTree) {

        mPoints = new Point[mWidth][mHeight];
        mQuadTree = quadTree;
        mWidth = mQuadTree.getWidth();
        mHeight = mQuadTree.getHeight();
    }

    public void setNumCandidates(int numCandidates) {

        mNumCandidates = numCandidates;
    }

    public void addNumPoints(int numPointsToAdd) {

        // add a point to the quadtree if it's empty
        if (mQuadTree.getCount() == 0) {
            mQuadTree.set(generateRandomPoint());
            numPointsToAdd--;
        }

        Point candidatePoints[] = new Point[mNumCandidates];
        double furthestDistance;
        double distance;
        int furthestDistanceIndex;

        // this loop iterates once for each point to be added to the quadtree
        for (; numPointsToAdd > 0; numPointsToAdd--) {

            // generate random candidate points that aren't already in the quadtree
            for (int i = 0; i < mNumCandidates; i++) {

                candidatePoints[i] = generateRandomPoint();
                while (mQuadTree.find(candidatePoints[i]) != null) { // while point already exists in quadtree

                    candidatePoints[i] = generateRandomPoint();          // generate a new point to replace it
                }
            }

            // if any of the candidate points we've created share
            // the same coordinates of another candidate point,
            // overwrite one of the duplicate points until all
            // candidate points are unique. -- TODO: TOO SLOW? FIX...?
            for (int j = 0; j < mNumCandidates; j++) {

                for (int k = 0; k < mNumCandidates; k++) {
                    if (j != k) {
                        while (candidatePoints[j].hasCoordinatesOf(candidatePoints[k])) {
                            candidatePoints[j] = generateRandomPoint();
                        }
                    }
                }
            }
            furthestDistance = 0;
            furthestDistanceIndex = 0;

            // for each candidate point:
            //   1. find distance between candidate point and
            //      nearest point in the quadtree
            //   2. if the distance is larger than the distances
            //      for the previous points, save the index of
            //      the candidate point to furthestDistanceIndex

            for (int i = 0; i < mNumCandidates; i++) {

                distance = findDistance(findNearestPointInQuadTree(candidatePoints[i]),
                        candidatePoints[i]);

                if (distance > furthestDistance) {
                    furthestDistance = distance;
                    furthestDistanceIndex = i;
                }
            }

            // add the candidate point that is furthest from the
            // other points in the quadtree to the quadtree
            mQuadTree.set(candidatePoints[furthestDistanceIndex]);
        }
    }

    public QuadTree getQuadTree() {
        return mQuadTree;
    }

    // This grabs one or more points that are near
    // referencePoint in the quadtree.
    // There is no guarantee that the point(s)
    // will be the closest point(s) to referencePoint,
    // but they/it will tend to be in the vicinity.

    public Point[] findPointsUnderParentNodeOf(Point referencePoint) {

        boolean refPointAlreadyInQuadTree = false;

        // if reference point is already in the quadtree,
        // adding it to the quadtree in order to facilitate our search would be redundant.
        // instead, we'll just use the already existing point.
        if (mQuadTree.find(referencePoint) != null)
            refPointAlreadyInQuadTree = true;
        else
            mQuadTree.set(referencePoint);

        Node node = mQuadTree.find(referencePoint);   // find the node containing our reference point.

        // go up a node in the tree until the current
        // node has 2+ points beneath it.
        while (mQuadTree.searchWithin(node).length < 2) {
            node = node.getParent();
        }

        // remove the reference point from quadtree
        // if it wasn't part of the quadtree
        // before this search.
        if (!refPointAlreadyInQuadTree) {
            mQuadTree.remove(referencePoint);
        }

        return mQuadTree.searchWithin(node); // find all points within the node (and its children) and return them
    }

    public Point findNearestPoint(Point referencePoint, Point[] candidatePoints) {

        // set var with a large enough value that any valid
        // distance we calculate is guaranteed to be smaller
        double nearestCandidateDistance = mWidth * mHeight;

        Point nearestCandidatePoint = null;

        for (Point curPoint : candidatePoints) {

            double curCandidateDistance = findDistance(referencePoint, curPoint);

            if (curCandidateDistance < nearestCandidateDistance
                    && !(curPoint.hasCoordinatesOf(referencePoint))) {

                nearestCandidateDistance = curCandidateDistance;
                nearestCandidatePoint = curPoint;
            }
        }

        // in the unlikely event that all of the randomly
        // generated candidate points share the same x,y coords
        // with referencePoint, generate random points until
        // we find one that doesn't.
        if (nearestCandidatePoint == null) {
            nearestCandidatePoint = generateRandomPoint();

            while (nearestCandidatePoint.hasCoordinatesOf(referencePoint)) {
                nearestCandidatePoint = generateRandomPoint();
            }
        }
        return nearestCandidatePoint;
    }

    public Point findNearestPointInQuadTree(Point referencePoint) {

        // grab some points in the vicinity of referencePoint
        Point points[] = findPointsUnderParentNodeOf(referencePoint);

        // pick the one that is closest to referencePoint and find distance
        // between this point and reference point (and multiply distance by 2)
        Point closePoint = findNearestPoint(referencePoint, points);
        double dist = (findDistance(referencePoint, closePoint)) * 2;

        // create a search area around referencePoint using above calculated distance
        double minX = referencePoint.getX() - dist;
        double minY = referencePoint.getY() - dist;
        double maxX = referencePoint.getX() + dist;
        double maxY = referencePoint.getY() + dist;

        // find the nearest points to referencePoint using the above search area
        Point nearestPoints[] = mQuadTree.searchWithin(minX, minY, maxX, maxY);

        return findNearestPoint(referencePoint, nearestPoints);
    }

    // use pythagorean theorum to find the distance between two points
    public double findDistance(Point point1, Point point2) {

        double xDiff = point1.getX() - point2.getX();
        double yDiff = point1.getY() - point2.getY();

        return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
    }

    public Point generateRandomPoint() {

        int randX = (int) (Math.random() * mWidth);
        int randY = (int) (Math.random() * mHeight);
        while (randX > mWidth) {
            randX--;
        }
        while (randY > mHeight) {
            randY--;
        }
        Point point = new Point(randX, randY, null);

        return point;
    }

    public Point[] toArray() {
        return mQuadTree.searchWithin(-1, -1, mWidth, mHeight);
    }

}
