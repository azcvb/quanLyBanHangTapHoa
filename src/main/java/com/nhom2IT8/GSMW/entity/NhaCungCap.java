package com.nhom2IT8.GSMW.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
	 	@Id
	    @Column(name = "ncc_id", length = 50)
	    private String ncc_id;

	    @Column(name = "ncc_ten")
	    private String ncc_ten;

	    @Column(name = "ncc_sdt")
	    private String ncc_sdt;

	    @Column(name = "ncc_email")
	    private String ncc_email;

	    @Column(name = "ncc_diachi")
	    private String ncc_diaChi;
	    
	    
	    
		public NhaCungCap() {}



		public NhaCungCap(String ncc_id, String ncc_ten, String ncc_sdt, String ncc_email, String ncc_diaChi) {
			this.ncc_id = ncc_id;
			this.ncc_ten = ncc_ten;
			this.ncc_sdt = ncc_sdt;
			this.ncc_email = ncc_email;
			this.ncc_diaChi = ncc_diaChi;
		}



		public String getNcc_id() {
			return ncc_id;
		}



		public void setNcc_id(String ncc_id) {
			this.ncc_id = ncc_id;
		}



		public String getNcc_ten() {
			return ncc_ten;
		}



		public void setNcc_ten(String ncc_ten) {
			this.ncc_ten = ncc_ten;
		}



		public String getNcc_sdt() {
			return ncc_sdt;
		}



		public void setNcc_sdt(String ncc_sdt) {
			this.ncc_sdt = ncc_sdt;
		}



		public String getNcc_email() {
			return ncc_email;
		}



		public void setNcc_email(String ncc_email) {
			this.ncc_email = ncc_email;
		}



		public String getNcc_diaChi() {
			return ncc_diaChi;
		}



		public void setNcc_diaChi(String ncc_diaChi) {
			this.ncc_diaChi = ncc_diaChi;
		}
		
		
		
		
	    
}
