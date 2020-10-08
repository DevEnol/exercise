package org.acme.resteasy.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Summary {

    @Id
    private Long id;

    private Double revenue;

    private Double adtv;

    private Integer noa;

    private Double adtvPerNoa;

    private Integer activeClient;

    private Double adtvPerActive;

    private Double assetGrowth;

    private Double tPlus;

    private Double margin;

    private Double repo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getAdtv() {
        return adtv;
    }

    public void setAdtv(Double adtv) {
        this.adtv = adtv;
    }

    public Integer getNoa() {
        return noa;
    }

    public void setNoa(Integer noa) {
        this.noa = noa;
    }

    public Double getAdtvPerNoa() {
        return adtvPerNoa;
    }

    public void setAdtvPerNoa(Double adtvPerNoa) {
        this.adtvPerNoa = adtvPerNoa;
    }

    public Integer getActiveClient() {
        return activeClient;
    }

    public void setActiveClient(Integer activeClient) {
        this.activeClient = activeClient;
    }

    public Double getAdtvPerActive() {
        return adtvPerActive;
    }

    public void setAdtvPerActive(Double adtvPerActive) {
        this.adtvPerActive = adtvPerActive;
    }

    public Double getAssetGrowth() {
        return assetGrowth;
    }

    public void setAssetGrowth(Double assetGrowth) {
        this.assetGrowth = assetGrowth;
    }

    public Double gettPlus() {
        return tPlus;
    }

    public void settPlus(Double tPlus) {
        this.tPlus = tPlus;
    }

    public Double getMargin() {
        return margin;
    }

    public void setMargin(Double margin) {
        this.margin = margin;
    }

    public Double getRepo() {
        return repo;
    }

    public void setRepo(Double repo) {
        this.repo = repo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Objects.equals(getId(), summary.getId()) &&
                Objects.equals(getRevenue(), summary.getRevenue()) &&
                Objects.equals(getAdtv(), summary.getAdtv()) &&
                Objects.equals(getNoa(), summary.getNoa()) &&
                Objects.equals(getAdtvPerNoa(), summary.getAdtvPerNoa()) &&
                Objects.equals(getActiveClient(), summary.getActiveClient()) &&
                Objects.equals(getAdtvPerActive(), summary.getAdtvPerActive()) &&
                Objects.equals(getAssetGrowth(), summary.getAssetGrowth()) &&
                Objects.equals(gettPlus(), summary.gettPlus()) &&
                Objects.equals(getMargin(), summary.getMargin()) &&
                Objects.equals(getRepo(), summary.getRepo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRevenue(), getAdtv(), getNoa(), getAdtvPerNoa(),
                getActiveClient(), getAdtvPerActive(), getAssetGrowth(), gettPlus(),
                getMargin(), getRepo());
    }
}
