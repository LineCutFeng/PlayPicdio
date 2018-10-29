package com.linecutfeng.lowpoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhou on 16-5-10.
 * <p/>
 * Delaunay算法
 */
final class Delaunay {

    private static final float EPSILON = 1.0f / 1048576.0f;

    private static int[][] supertriangle(List<int[]> vertices) {
        int xmin = Integer.MAX_VALUE;
        int ymin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        int ymax = Integer.MIN_VALUE;

        float dx, dy, dmax, xmid, ymid;

        for (int i = vertices.size() - 1; i >= 0; i--) {
            int[] p = vertices.get(i);
            if (p[0] < xmin) xmin = p[0];
            if (p[0] > xmax) xmax = p[0];
            if (p[1] < ymin) ymin = p[1];
            if (p[1] > ymax) ymax = p[1];
        }

        dx = xmax - xmin;
        dy = ymax - ymin;

        dmax = Math.max(dx, dy);

        xmid = (xmin + dx * 0.5f);
        ymid = (ymin + dy * 0.5f);

        return new int[][]{{(int) (xmid - 20 * dmax), (int) (ymid - dmax)},
                {(int) xmid, (int) (ymid + 20 * dmax)},
                {(int) (xmid + 20 * dmax), (int) (ymid - dmax)}};
    }

    private static Circumcircle circumcircle(List<int[]> vertices, int i, int j, int k) {
        int x1 = vertices.get(i)[0];
        int y1 = vertices.get(i)[1];
        int x2 = vertices.get(j)[0];
        int y2 = vertices.get(j)[1];
        int x3 = vertices.get(k)[0];
        int y3 = vertices.get(k)[1];


        int fabsy1y2 = Math.abs(y1 - y2);
        int fabsy2y3 = Math.abs(y2 - y3);

        float xc, yc, m1, m2, mx1, mx2, my1, my2, dx, dy;

//        if (fabsy1y2 <= 0 && fabsy2y3 <= 0) {
//            throw new RuntimeException("Eek! Coincident points!");
//        }

        if (fabsy1y2 <= 0) {
            m2 = -((float) (x3 - x2) / (y3 - y2));
            mx2 = (x2 + x3) / 2f;
            my2 = (y2 + y3) / 2f;
            xc = (x2 + x1) / 2f;
            yc = m2 * (xc - mx2) + my2;
        } else if (fabsy2y3 <= 0) {
            m1 = -((float) (x2 - x1) / (y2 - y1));
            mx1 = (x1 + x2) / 2f;
            my1 = (y1 + y2) / 2f;
            xc = (x3 + x2) / 2f;
            yc = m1 * (xc - mx1) + my1;
        } else {
            m1 = -((float) (x2 - x1) / (y2 - y1));
            m2 = -((float) (x3 - x2) / (y3 - y2));
            mx1 = (x1 + x2) / 2f;
            mx2 = (x2 + x3) / 2f;
            my1 = (y1 + y2) / 2f;
            my2 = (y2 + y3) / 2f;
            xc = (m1 * mx1 - m2 * mx2 + my2 - my1) / (m1 - m2);
            yc = (fabsy1y2 > fabsy2y3) ?
                    m1 * (xc - mx1) + my1 :
                    m2 * (xc - mx2) + my2;
        }

        dx = x2 - xc;
        dy = y2 - yc;

        return new Circumcircle(i, j, k, xc, yc, (dx * dx + dy * dy));
    }

    /**
     * 去重
     * @param edges
     */
    private static void dedup(ArrayList<Integer> edges) {
        int a, b, m, n;
        for (int j = edges.size(); j > 0; ) {
            while (j > edges.size()) {
                j--;
            }
            if (j <= 0) {
                break;
            }
            b = edges.get(--j);
            a = edges.get(--j);

            for (int i = j; i > 0; ) {
                n = edges.get(--i);
                m = edges.get(--i);

                if ((a == m && b == n) || (a == n && b == m)) {
                    if (j + 1 < edges.size())
                        edges.remove(j + 1);
                    edges.remove(j);
                    if (i + 1 < edges.size())
                        edges.remove(i + 1);
                    edges.remove(i);
                    break;
                }
            }
        }
    }

    static List<Integer> triangulate(final List<int[]> vertices) {
        int n = vertices.size();

        if (n < 3) {
            return new ArrayList<>();
        }

        Integer[] indices = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            indices[i] = i;
        }

        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return vertices.get(rhs)[0] - vertices.get(lhs)[0];
            }
        });

        int[][] st = supertriangle(vertices);

        vertices.add(st[0]);
        vertices.add(st[1]);
        vertices.add(st[2]);

        ArrayList<Circumcircle> open = new ArrayList<>();
        open.add(circumcircle(vertices, n, n + 1, n + 2));

        ArrayList<Circumcircle> closed = new ArrayList<>();

        ArrayList<Integer> edges = new ArrayList<>();

        for (int i = indices.length - 1; i >= 0; i--) {

            int c = indices[i];

            for (int j = open.size() - 1; j >= 0; j--) {

                Circumcircle cj = open.get(j);
                int[] vj = vertices.get(c);

                float dx = vj[0] - cj.x;

                if (dx > 0 && dx * dx > cj.r) {
                    closed.add(cj);
                    open.remove(j);
                    continue;
                }

                float dy = vj[1] - cj.y;

                if (dx * dx + dy * dy - cj.r > EPSILON) {
                    continue;
                }

                edges.add(cj.i);
                edges.add(cj.j);
                edges.add(cj.j);
                edges.add(cj.k);
                edges.add(cj.k);
                edges.add(cj.i);

                open.remove(j);
            }

            dedup(edges);

            for (int j = edges.size(); j > 0; ) {
                int b = edges.get(--j);
                int a = edges.get(--j);
                open.add(circumcircle(vertices, a, b, c));
            }

            edges.clear();

        }

        for (int i = open.size() - 1; i >= 0; i--) {
            closed.add(open.get(i));
        }

        open.clear();

        ArrayList<Integer> out = new ArrayList<>();

        for (int i = closed.size() - 1; i >= 0; i--) {
            Circumcircle ci = closed.get(i);
            if (ci.i < n && ci.j < n && ci.k < n) {
                out.add((int) ci.i);
                out.add((int) ci.j);
                out.add((int) ci.k);
            }
        }
        return out;
    }

    private static class Circumcircle {
        public int i, j, k;
        float x, y, r;

        public Circumcircle(int i, int j, int k, float x, float y, float r) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

}
