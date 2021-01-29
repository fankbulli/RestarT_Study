package pdf.replace;
public enum KeyEnum {

    姓名("name", "姓名&"),
    性别("sex", "性别&"),
    年龄("age", "年龄&"),
    ID("id", "ID&"),
    学历("stu", "学历&");

    //属性
    private String property;
    //关键词
    private String keyWord;
    KeyEnum(String property, String keyWord) {
        this.property = property;
        this.keyWord = keyWord;
    }

    public static String value(String property) {
        for (KeyEnum e : values()) {
            if (e.getProperty().equals(property)) {
                return e.getKeyWord();
            }
        }
        return null;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }


}
