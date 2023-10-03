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

			private float limit1;
			private float limit2;
			private float limit3;

			private int raisepercent1;
			private int raisepercent2;
			private int raisepercent3;
			private int raisepercent4;

			public float getLimit1() {
				return limit1;
			}

			public void setLimit1(float limit1) {
				this.limit1 = limit1;
			}

			public float getLimit2() {
				return limit2;
			}

			public void setLimit2(float limit2) {
				this.limit2 = limit2;
			}

			public float getLimit3() {
				return limit3;
			}

			public void setLimit3(float limit3) {
				this.limit3 = limit3;
			}

			public int getRaisepercent1() {
				return raisepercent1;
			}

			public void setRaisepercent1(int raisepercent1) {
				this.raisepercent1 = raisepercent1;
			}

			public int getRaisepercent2() {
				return raisepercent2;
			}

			public void setRaisepercent2(int raisepercent2) {
				this.raisepercent2 = raisepercent2;
			}

			public int getRaisepercent3() {
				return raisepercent3;
			}

			public void setRaisepercent3(int raisepercent3) {
				this.raisepercent3 = raisepercent3;
			}

			public int getRaisepercent4() {
				return raisepercent4;
			}

			public void setRaisepercent4(int raisepercent4) {
				this.raisepercent4 = raisepercent4;
			}

		}
	}
}
