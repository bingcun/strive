package ai.yuhan.other.datastructure.hanshunping.blockingqueue;

/**
 * @description:
 * 表示吐司的状态:
 * DRY:烘干的
 * BUTTERED:吐了黄油的
 * JAMMED:涂了果酱的
 * 吐司的状态只能由DRY->BUTTERED->JAMMED
 *
 * @author: bingcun.chen
 * @Date: 2021/10/11 10:35
 * @Version 1.0
 */
public class Toast {
    public enum Status {DRY, BUTTERED, JAMMED}
    private Status status = Status.DRY;//默认状态为DRY
    private final int id;
    public Toast(int id) { this.id =  id;}
    public void butter() {status = Status.BUTTERED;}
    public void jam() {status = Status.JAMMED;}
    public Status getStatus() {return status;}
    public int getId() {return id;}
    public String toString() {
        return "Toast id: " + id + ", status: " + status;
    }


}
