package com.caogen.jfd.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Spuiln
 *
 */
public class Distance implements Serializable {

	private static final long serialVersionUID = -5917087452970473948L;
	private String status;
	private String info;
	private String infocode;
	private List<Result> results;

	@Override
	public String toString() {
		return "Distance [status=" + status + ", info=" + info + ", infocode=" + infocode + ", results=" + results
				+ "]";
	}

	public class Result {
		private String origin_id;
		private String dest_id;
		private String distance;
		private String duration;

		@Override
		public String toString() {
			return "Result [origin_id=" + origin_id + ", dest_id=" + dest_id + ", distance=" + distance + ", duration="
					+ duration + "]";
		}

		public String getOrigin_id() {
			return origin_id;
		}

		public void setOrigin_id(String origin_id) {
			this.origin_id = origin_id;
		}

		public String getDest_id() {
			return dest_id;
		}

		public void setDest_id(String dest_id) {
			this.dest_id = dest_id;
		}

		public String getDistance() {
			return distance;
		}

		public void setDistance(String distance) {
			this.distance = distance;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
