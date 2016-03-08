package com.icss.model;
// Generated 2016-3-8 18:59:14 by Hibernate Tools 4.0.0.Final

import java.util.Date;

/**
 * WuyeTousu generated by hbm2java
 */
public class WuyeTousu implements java.io.Serializable {

	private String id;
	private String xqId;
	private String yonghuId;
	private String tousuBiaoti;
	private String tousuNeirong;
	private Integer tousuZhuangtai;
	private Date tousuShijian;
	private Date chuliShijian;
	private String chuliNeirong;

	public WuyeTousu() {
	}

	public WuyeTousu(String id) {
		this.id = id;
	}

	public WuyeTousu(String id, String xqId, String yonghuId, String tousuBiaoti, String tousuNeirong,
			Integer tousuZhuangtai, Date tousuShijian, Date chuliShijian, String chuliNeirong) {
		this.id = id;
		this.xqId = xqId;
		this.yonghuId = yonghuId;
		this.tousuBiaoti = tousuBiaoti;
		this.tousuNeirong = tousuNeirong;
		this.tousuZhuangtai = tousuZhuangtai;
		this.tousuShijian = tousuShijian;
		this.chuliShijian = chuliShijian;
		this.chuliNeirong = chuliNeirong;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXqId() {
		return this.xqId;
	}

	public void setXqId(String xqId) {
		this.xqId = xqId;
	}

	public String getYonghuId() {
		return this.yonghuId;
	}

	public void setYonghuId(String yonghuId) {
		this.yonghuId = yonghuId;
	}

	public String getTousuBiaoti() {
		return this.tousuBiaoti;
	}

	public void setTousuBiaoti(String tousuBiaoti) {
		this.tousuBiaoti = tousuBiaoti;
	}

	public String getTousuNeirong() {
		return this.tousuNeirong;
	}

	public void setTousuNeirong(String tousuNeirong) {
		this.tousuNeirong = tousuNeirong;
	}

	public Integer getTousuZhuangtai() {
		return this.tousuZhuangtai;
	}

	public void setTousuZhuangtai(Integer tousuZhuangtai) {
		this.tousuZhuangtai = tousuZhuangtai;
	}

	public Date getTousuShijian() {
		return this.tousuShijian;
	}

	public void setTousuShijian(Date tousuShijian) {
		this.tousuShijian = tousuShijian;
	}

	public Date getChuliShijian() {
		return this.chuliShijian;
	}

	public void setChuliShijian(Date chuliShijian) {
		this.chuliShijian = chuliShijian;
	}

	public String getChuliNeirong() {
		return this.chuliNeirong;
	}

	public void setChuliNeirong(String chuliNeirong) {
		this.chuliNeirong = chuliNeirong;
	}

}
