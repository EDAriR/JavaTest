package sideProjectTest;

import java.util.Date;

public class Model {

    private long sequence;
    private String id;
    private Date date;

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TO convert(){

        TO to = new TO();

        to.setSequence(sequence);
        to.setDate(new Date());

        return to;
    }
}
