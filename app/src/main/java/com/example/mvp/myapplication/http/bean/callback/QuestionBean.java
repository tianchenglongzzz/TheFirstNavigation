package com.example.mvp.myapplication.http.bean.callback;

/**
 * @packge: com.example.mvp.myapplication.http.bean.callback
 * @filename:QuestionBean
 * @date :${DATA} 10:43
 */
public class QuestionBean {

    /**
     * answer : <p>用户可以针对任意一条新闻调整自己喜好的字体大小</p>
     <p>打开任意一条新闻，点击右上角… 图标，在弹出框体中点选“字体”，然后按照自己喜好调整字体显示大小</p>
     * id : 49ecde9e8ff3462d84831e7025ea2661
     * question : 如何调整文章正文字体大小？
     */

    private String answer;
    private String id;
    private String question;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
