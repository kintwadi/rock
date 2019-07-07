package com.coderock.app.entities;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Data  implements Serializable{

		private String name;
		private String company;
		
		
		public Data() {
		
		}
		@Override
		public String toString() {
			return "Data [name=" + name + ", company=" + company + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		
		
}
