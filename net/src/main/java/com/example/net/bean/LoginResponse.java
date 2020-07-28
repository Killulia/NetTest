package com.example.net.bean;

import java.util.List;

public class LoginResponse {

    /**
     * returnCode : 200
     * returnMsg : 登录成功
     * returnData : {"glybm":"0812125","password":"21218cca77804d2ba1922c33e0151105","version":"45","imsi":"e1aa424501775aa7","version_new":"45","url":null,"ssxzqh":"110108012000","xzqhmc":"苏州街路社区新居民服务中心","fwzbh":"bc584c0dd0fa00","glyxm":"陈广顺","xqbh":null,"glybh":"bc8cb30509e700","sjhm":"1440062206908","ssxq":[{"xqbh":"bc584c0dd0fa01","xqmc":"苏州街路社区"},{"xqbh":"bc584c0dd0fa02","xqmc":"八一中学社区"}],"pcsbh":"1101080853000"}
     * pageCount : null
     * rowsCount : null
     * startNum : null
     * rylx : null
     */

    private int returnCode;
    private String returnMsg;
    private ReturnDataBean returnData;
    private String pageCount;
    private String rowsCount;
    private String startNum;
    private String rylx;

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public ReturnDataBean getReturnData() {
        return returnData;
    }

    public void setReturnData(ReturnDataBean returnData) {
        this.returnData = returnData;
    }

    public Object getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public Object getRowsCount() {
        return rowsCount;
    }

    public void setRowsCount(String rowsCount) {
        this.rowsCount = rowsCount;
    }

    public Object getStartNum() {
        return startNum;
    }

    public void setStartNum(String startNum) {
        this.startNum = startNum;
    }

    public Object getRylx() {
        return rylx;
    }

    public void setRylx(String rylx) {
        this.rylx = rylx;
    }

    public static class ReturnDataBean {
        /**
         * glybm : 0812125
         * password : 21218cca77804d2ba1922c33e0151105
         * version : 45
         * imsi : e1aa424501775aa7
         * version_new : 45
         * url : null
         * ssxzqh : 110108012000
         * xzqhmc : 苏州街路社区新居民服务中心
         * fwzbh : bc584c0dd0fa00
         * glyxm : 陈广顺
         * xqbh : null
         * glybh : bc8cb30509e700
         * sjhm : 1440062206908
         * ssxq : [{"xqbh":"bc584c0dd0fa01","xqmc":"苏州街路社区"},{"xqbh":"bc584c0dd0fa02","xqmc":"八一中学社区"}]
         * pcsbh : 1101080853000
         */

        private String glybm;
        private String password;
        private String version;
        private String imsi;
        private String version_new;
        private Object url;
        private String ssxzqh;
        private String xzqhmc;
        private String fwzbh;
        private String glyxm;
        private Object xqbh;
        private String glybh;
        private String sjhm;
        private String pcsbh;
        private List<SsxqBean> ssxq;

        public String getGlybm() {
            return glybm;
        }

        public void setGlybm(String glybm) {
            this.glybm = glybm;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getImsi() {
            return imsi;
        }

        public void setImsi(String imsi) {
            this.imsi = imsi;
        }

        public String getVersion_new() {
            return version_new;
        }

        public void setVersion_new(String version_new) {
            this.version_new = version_new;
        }

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
            this.url = url;
        }

        public String getSsxzqh() {
            return ssxzqh;
        }

        public void setSsxzqh(String ssxzqh) {
            this.ssxzqh = ssxzqh;
        }

        public String getXzqhmc() {
            return xzqhmc;
        }

        public void setXzqhmc(String xzqhmc) {
            this.xzqhmc = xzqhmc;
        }

        public String getFwzbh() {
            return fwzbh;
        }

        public void setFwzbh(String fwzbh) {
            this.fwzbh = fwzbh;
        }

        public String getGlyxm() {
            return glyxm;
        }

        public void setGlyxm(String glyxm) {
            this.glyxm = glyxm;
        }

        public Object getXqbh() {
            return xqbh;
        }

        public void setXqbh(Object xqbh) {
            this.xqbh = xqbh;
        }

        public String getGlybh() {
            return glybh;
        }

        public void setGlybh(String glybh) {
            this.glybh = glybh;
        }

        public String getSjhm() {
            return sjhm;
        }

        public void setSjhm(String sjhm) {
            this.sjhm = sjhm;
        }

        public String getPcsbh() {
            return pcsbh;
        }

        public void setPcsbh(String pcsbh) {
            this.pcsbh = pcsbh;
        }

        public List<SsxqBean> getSsxq() {
            return ssxq;
        }

        public void setSsxq(List<SsxqBean> ssxq) {
            this.ssxq = ssxq;
        }

        public static class SsxqBean {
            /**
             * xqbh : bc584c0dd0fa01
             * xqmc : 苏州街路社区
             */

            private String xqbh;
            private String xqmc;

            public String getXqbh() {
                return xqbh;
            }

            public void setXqbh(String xqbh) {
                this.xqbh = xqbh;
            }

            public String getXqmc() {
                return xqmc;
            }

            public void setXqmc(String xqmc) {
                this.xqmc = xqmc;
            }
        }
    }
}
