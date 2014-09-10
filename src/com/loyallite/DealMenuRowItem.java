package com.loyallite;

public class DealMenuRowItem {

	 private String deal_name;
	 private int deal_pic_id;
	 private String deal_cost;
	 private String deal_description;

	 public DealMenuRowItem(String deal_name, int deal_pic_id, String deal_cost,
	   String deal_description) {

	  this.deal_name = deal_name;
	  this.deal_pic_id = deal_pic_id;
	  this.deal_cost = deal_cost;
	  this.deal_description = deal_description;
	 }

	 public String getDeal_name() {
	  return deal_name;
	 }

	 public void setMember_name(String deal_name) {
	  this.deal_name = deal_name;
	 }

	 public int getDeal_pic_id() {
	  return deal_pic_id;
	 }

	 public void setProfile_pic_id(int deal_pic_id) {
	  this.deal_pic_id = deal_pic_id;
	 }

	 public String getDeal_cost() {
	  return deal_cost;
	 }

	 public void setStatus(String deal_cost) {
	  this.deal_cost = deal_cost;
	 }

	 public String getDeal_description() {
	  return deal_description;
	 }

	 public void setContactType(String deal_description) {
	  this.deal_description = deal_description;
	 }

	}