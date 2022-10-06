package com.boot.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Mr.wxx
 * @create 2021-06-28-22:48
 **/

@Table(name="stream_line")
public class StreamLine {
    @Id
    String streamLineId;
    @Column(name = "name")
    String name;
    @Column(name = "area")
    String area;
    @Column(name = "spec_id")
    String specId;
    @Column(name = "vpl_id")
    String vplId;
    @Column(name = "status")
    byte status;
    @Column(name = "create_time")
    Date createTime;
    @Column(name = "modify_time")
    Date modifyTime;
    @Column(name = "modify_person")
    String modifyPerson;

    public StreamLine() {
    }
}
