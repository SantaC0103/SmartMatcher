package com.big.tuwien.SmartMatcher.strategy.pso.swarm;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

import com.big.tuwien.SmartMatcher.strategy.pso.MetaModelBuilder;
import com.big.tuwien.SmartMatcher.strategy.pso.PSOMapping;

public class TDPSO {
	private LhsMM lhsMM;
	private RhsMM rhsMM;
	 
	
	public TDPSO() {
		DOMConfigurator.configure("junit_log4j.xml");
		lhsMM = new LhsMM();
		rhsMM = new RhsMM();
	}

	
	public class LhsMM extends MetaModelBuilder {
		private MetaModel_ mm;
		
		public LhsMM() {
			mm = mm(li(
					c("Person", 
						li(
							a("firstname"),
							a("age")
						)
					).as("C1"),
					c("Family", 
						li(
							a("lastname"),
							a("members")
						)
					).as("C2"),
					c("Address", 
						li(
							a("street"),
							a("city"),
							a("country")
						)
					).as("C3"),
					r("belongsTo", c("C1"), c("C2")),
					r("member", c("C2"), c("C1")),
					r("livesAt", c("C2"), c("C3"))
				)
				);
		}
		public MetaModel_ getMetaModel() {
			return mm;
		}
	}
	
	
	public class RhsMM extends MetaModelBuilder {
		private MetaModel_ mm;
		
		public RhsMM() {
			mm = mm(li(
					c("Person", 
						li(
							a("firstname"),
							a("age")
						)
					).as("C1"),
					c("Family", 
						li(
							a("lastname"),
							a("members")
						)
					).as("C2"),
					c("Address", 
						li(
							a("street"),
							a("city"),
							a("country")
						)
					).as("C3"),
					r("belongsTo", c("C1"), c("C2")),
					r("member", c("C2"), c("C1")),
					r("livesAt", c("C2"), c("C3"))
				)
				);
		}
		public MetaModel_ getMetaModel() {
			return mm;
		}
	}

	
	@Test
	public void testDPSOOptimization() {
		DPSO dpso = new DPSO(
				lhsMM.getMetaModel(), 
				rhsMM.getMetaModel());
		PSOMapping optimized = dpso.optimize();
		
		System.out.println("Optimized: " + optimized);
	}
}
