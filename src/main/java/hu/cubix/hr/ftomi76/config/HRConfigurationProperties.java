package hu.cubix.hr.ftomi76.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//application properties values reflected here as class hierarchy below
//hr.smartpayraise.worktime.limit1=2.5
//hr.smartpayraise.worktime.limit2=5
//hr.smartpayraise.worktime.limit3=10
//
//hr.smartpayraise.worktime.raisepercent1=0
//hr.smartpayraise.worktime.raisepercent2=2
//hr.smartpayraise.worktime.raisepercent3=5
//hr.smartpayraise.worktime.raisepercent4=10

@ConfigurationProperties(prefix = "hr")
@Component
public class HRConfigurationProperties {
	private SmartPayraise smartpayraise;

	public SmartPayraise getSmartPayraise() {
		return smartpayraise;
	}

	public void setSmartPayraise(SmartPayraise smartpayraise) {
		this.smartpayraise = smartpayraise;
	}

	public static class SmartPayraise {
		private Worktime worktime;

		public Worktime getWorktime() {
			return worktime;
		}

		public void setWorktime(Worktime worktime) {
			this.worktime = worktime;
		}

		public static class Worktime {

			private float[] limit;
			private int[] raisepercent;

			public float[] getLimit() {
				return limit;
			}

			public void setLimit(float[] limit) {
				this.limit = limit;
			}

			public int[] getRaisepercent() {
				return raisepercent;
			}

			public void setRaisepercent(int[] raisepercent) {
				this.raisepercent = raisepercent;
			}

		}

	}
}
