package com.lcf.emojimosaic;

import com.lcf.emojimosaic.quadtree.Point;

public class EmojiPoint {

    private int matchPosition;
    private Point point;

    public int getMatchPosition() {
        return matchPosition;
    }

    public void setMatchPosition(int matchPosition) {
        this.matchPosition = matchPosition;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
