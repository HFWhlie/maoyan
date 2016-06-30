package com.atguigu.maoyan.bean;

import java.util.List;

/**
 * Created by tao on 2016/6/30.
 * TOP100
 */
public class Topbean {

    /**
     * boardtype : 1
     * content : 《猫眼经典Top100》——将猫眼电影库中的经典影片，按照评分和评分人数综合排序，取前100名，每天上午10点更新，相关数据来源于“猫眼电影库”。
     * created : 2016-06-30
     * id : 4
     * movies : [{"dir":"陈凯歌","id":1203,"img":"http://p1.meituan.net/w.h/movie/20803f59291c47e1e116c11963ce019e68711.jpg","nm":"霸王别姬","rt":"1993-01-01(中国香港)","sc":9.6,"star":"张国荣,张丰毅,巩俐"},{"dir":"弗兰克·德拉邦特","id":1297,"img":"http://p0.meituan.net/w.h/movie/__40191813__4767047.jpg","nm":"肖申克的救赎","rt":"1994-10-14(美国)","sc":9.5,"star":"蒂姆·罗宾斯,摩根·弗里曼,鲍勃·冈顿"},{"dir":"吕克·贝松","id":4055,"img":"http://p0.meituan.net/w.h/movie/fc9d78dd2ce84d20e53b6d1ae2eea4fb1515304.jpg","nm":"这个杀手不太冷","rt":"1994-09-14(法国)","sc":9.5,"star":"让·雷诺,加里·奥德曼,娜塔莉·波特曼"},{"dir":"罗伯特·泽米吉斯","id":1633,"img":"http://p0.meituan.net/w.h/movie/53/1541925.jpg","nm":"阿甘正传","rt":"1994-07-06(美国)","sc":9.4,"star":"汤姆·汉克斯,罗宾·怀特,加里·西尼斯"},{"dir":"詹姆斯·卡梅隆","id":267,"img":"http://p0.meituan.net/w.h/movie/11/324629.jpg","nm":"泰坦尼克号","rt":"1998-04-03","sc":9.5,"star":"莱昂纳多·迪卡普里奥,凯特·温丝莱特,比利·赞恩"},{"dir":"宫崎骏","id":123,"img":"http://p0.meituan.net/w.h/movie/99/678407.jpg","nm":"龙猫","rt":"1988-04-16(日本)","sc":9.2,"star":"日高法子,坂本千夏,糸井重里"},{"dir":"李力持","id":837,"img":"http://p0.meituan.net/w.h/movie/62/109878.jpg","nm":"唐伯虎点秋香","rt":"1993-07-01(中国香港)","sc":9.3,"star":"周星驰,巩俐,郑佩佩"},{"dir":"厄文·克什纳","id":4727,"img":"http://p0.meituan.net/w.h/movie/36/6540581.jpg","nm":"星球大战2：帝国反击战","rt":"1980-05-21(美国)","sc":9.1,"star":"马克·哈米尔,哈里森·福特,凯丽·费雪"},{"dir":"弗朗西斯·福特·科波拉","id":1247,"img":"http://p0.meituan.net/w.h/movie/92/8212889.jpg","nm":"教父","rt":"1972-03-24(美国)","sc":9.3,"star":"马龙·白兰度,阿尔·帕西诺,詹姆斯·凯恩"},{"dir":"理查德·马昆德","id":5201,"img":"http://p0.meituan.net/w.h/movie/36/2476594.jpg","nm":"星球大战3：绝地归来","rt":"1983-05-25(美国)","sc":9.2,"star":"马克·哈米尔,哈里森·福特,凯丽·费雪"}]
     * paging : {"hasMore":true,"limit":10,"offset":0,"total":100}
     * shareHidden : 1
     * title : 猫眼经典Top100
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int boardtype;
        private String content;
        private String created;
        private int id;
        /**
         * hasMore : true
         * limit : 10
         * offset : 0
         * total : 100
         */

        private PagingBean paging;
        private int shareHidden;
        private String title;
        /**
         * dir : 陈凯歌
         * id : 1203
         * img : http://p1.meituan.net/w.h/movie/20803f59291c47e1e116c11963ce019e68711.jpg
         * nm : 霸王别姬
         * rt : 1993-01-01(中国香港)
         * sc : 9.6
         * star : 张国荣,张丰毅,巩俐
         */

        private List<MoviesBean> movies;

        public int getBoardtype() {
            return boardtype;
        }

        public void setBoardtype(int boardtype) {
            this.boardtype = boardtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public int getShareHidden() {
            return shareHidden;
        }

        public void setShareHidden(int shareHidden) {
            this.shareHidden = shareHidden;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class PagingBean {
            private boolean hasMore;
            private int limit;
            private int offset;
            private int total;

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class MoviesBean {
            private String dir;
            private int id;
            private String img;
            private String nm;
            private String rt;
            private double sc;
            private String star;

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }
        }
    }
}
