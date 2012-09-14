package com.oasis.wolfburg.model.route;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;

@Table(name = "WL_STOP")
@SequenceGenerator(name = "WL_STOP_SEQ")
@Cache
public class Stop extends BaseModel implements Comparable<Integer>, Comparator<Stop> {

    private static final long serialVersionUID = -8527439927824037960L;

    @Id
    private Long id;

    /**
     * 关联的线路ID
     */
    @Column(name = "ROUTE_ID")
    private Long routeId;

    /**
     * 物流节点ID
     */
    @Column(name = "POS_ID")
    private Long posId;

    /**
     * 物流节点名称
     */
    @Column(name = "pos_name")
    private String posName;

    /**
     * 站点排序
     */
    @Column(name = "SEQ_NUM")
    private int seqNum;



    public int getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    @Override
    public int compareTo(Integer seqNum) {
        return this.getSeqNum() < seqNum ? 0 : 1;
    }

    @Override
    public int compare(Stop src, Stop target) {
        return src.compareTo(target.getSeqNum());
    }

}
