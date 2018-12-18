package com.bksx.nettest.effective;

public class C2_2 {

    private int id;
    private String name;
    private String gentle;
    private int no;
    private String country;
    private String bir;

    public C2_2(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.gentle = builder.gentle;
        this.no = builder.no;
        this.country = builder.country;
        this.bir = builder.bir;
    }

    public static class Builder implements com.bksx.nettest.effective.Builder<C2_2> {
        private final int id;
        private final String name;
        private String gentle = "";
        private int no = 0;
        private String country = "";
        private String bir = "";

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder gentle(String gentle){
            this.gentle = gentle;
            return this;
        }

        public Builder no(int no){
            this.no = no;
            return this;
        }

        public Builder conutry(String country){
            this.country = country;
            return this;
        }

        public Builder bir(String bir){
            this.bir = bir;
            return this;
        }

        @Override
        public C2_2 build() {
            return new C2_2(this);  //将Builder做成一个通用接口
        }


//        public C2_2 build(){
//
//            return new C2_2(this);
//        }




    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGentle() {
        return gentle;
    }

    public void setGentle(String gentle) {
        this.gentle = gentle;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }
}
