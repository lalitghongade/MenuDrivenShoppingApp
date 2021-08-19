package model;

public class OrderStatus {

		private int statusId;
		private String statusType;
		
		public OrderStatus() {
		}

		public int getStatusId() {
			return statusId;
		}

		public void setStatusId(int statusId) {
			this.statusId = statusId;
		}

		public String getStatusType() {
			return statusType;
		}

		public void setStatusType(String statusType) {
			this.statusType = statusType;
		}

		public OrderStatus(int statusId, String statusType) {
			super();
			this.statusId = statusId;
			this.statusType = statusType;
		}

		@Override
		public String toString() {
			return "OrderStatus [statusId=" + statusId + ", statusType=" + statusType + "]";
		}
		
		
		
		}
