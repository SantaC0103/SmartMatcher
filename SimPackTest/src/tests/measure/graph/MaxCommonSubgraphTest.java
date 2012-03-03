/*
 * $Id: MaxGraphIsoCoveringTest.java 757 2008-04-17 17:42:53Z kiefer $
 *
 * Copyright (C) 2004-2008 by the Dynamic and Distributed Information Systems
 * Group at the University of Zurich, Switzerland
 *
 * All inquiries regarding the copyrights of this project should be addressed
 * to:
 *
 * Prof. Abraham Bernstein, PhD
 * Dynamic and Distributed Information Systems Group
 * Department of Informatics
 * University of Zurich
 * Binzmuehlestrasse 14
 * CH-8050 Zurich, Switzerland
 *
 * SimPack is licensed under the GNU Lesser General Public License
 *
 * Details can be found at http://www.gnu.org/licenses/lgpl.html or at
 * http://www.ifi.uzh.ch/ddis/simpack.html
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA
 *
 */
package tests.measure.graph;

import java.util.TreeSet;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import simpack.accessor.graph.SimpleGraphAccessor;
import simpack.api.IGraphAccessor;
import simpack.measure.graph.MaxCommonSubgraphIsoValiente;
import simpack.measure.graph.MaxGraphIsoCovering;
import simpack.util.graph.GraphNode;

/**
 * @author Christoph Kiefer
 * @version $Id: MaxGraphIsoCoveringTest.java 757 2008-04-17 17:42:53Z kiefer $
 */
public class MaxCommonSubgraphTest extends TestCase {

	public static Logger logger = Logger
			.getLogger(MaxCommonSubgraphTest.class);

	private IGraphAccessor graph1, graph2, graph3, graph4, emptyGraph;
	

	public MaxCommonSubgraphTest() {
		DOMConfigurator.configure("junit_log4j.xml");
	}
	
	
	protected void setUp() throws Exception {
		graph1 = generateSampleG11();
		graph2 = generateSampleG12();
		graph3 = generateSampleG3();
		graph4 = generateSampleG4();
		emptyGraph = new SimpleGraphAccessor();
		assertNotNull(graph1);
		assertNotNull(graph2);
		assertNotNull(graph3);
		assertNotNull(graph4);
		assertNotNull(emptyGraph);
	}

	
	public void testMaxCommonSubgraph() {
		double structuralWeight = 0.5;
		double labelWeight = 0.5;
		
		MaxCommonSubgraphIsoValiente commonSubgraph =
			new MaxCommonSubgraphIsoValiente(graph1, graph2, 3, 
					structuralWeight, labelWeight, "average");
		assertTrue(commonSubgraph.calculate());
		
		TreeSet<String> cliques = commonSubgraph.getCliqueList();
		
		System.out.println("Structural weight: " + structuralWeight);
		System.out.println("Label weight: " + labelWeight);
		System.out.println("Cliques: " + cliques);
	}
	
	
	public void testMaxCommonSubgraph2() {
		double structuralWeight = 0.3;
		double labelWeight = 0.7;
		
		MaxCommonSubgraphIsoValiente commonSubgraph =
			new MaxCommonSubgraphIsoValiente(graph1, graph2, 3, 
					structuralWeight, labelWeight, "average");
		assertTrue(commonSubgraph.calculate());
		
		TreeSet<String> cliques = commonSubgraph.getCliqueList();
		
		System.out.println("Structural weight: " + structuralWeight);
		System.out.println("Label weight: " + labelWeight);
		System.out.println("Cliques: " + cliques);
	}
	
	
	public void testMaxCommonSubgraph3() {
		double structuralWeight = 0.1;
		double labelWeight = 0.9;
		
		MaxCommonSubgraphIsoValiente commonSubgraph =
			new MaxCommonSubgraphIsoValiente(graph1, graph2, 3, 
					structuralWeight, labelWeight, "average");
		assertTrue(commonSubgraph.calculate());
		
		TreeSet<String> cliques = commonSubgraph.getCliqueList();
		
		System.out.println("Structural weight: " + structuralWeight);
		System.out.println("Label weight: " + labelWeight);
		System.out.println("Cliques: " + cliques);
	}
	
	
	
	
	
	
	private IGraphAccessor generateSampleG11() {
		SimpleGraphAccessor g1 = new SimpleGraphAccessor();

		GraphNode n1 = new GraphNode("Person");
		GraphNode n2 = new GraphNode("fname");
		GraphNode n3 = new GraphNode("lastname");
		GraphNode n4 = new GraphNode("Address");
		GraphNode n5 = new GraphNode("street");
		GraphNode n6 = new GraphNode("city");
		GraphNode n7 = new GraphNode("country");

		g1.setEdge(n1, n2);
		g1.setEdge(n1, n3);
		g1.setEdge(n1, n4);
		g1.setEdge(n4, n5);
		g1.setEdge(n4, n6);
		g1.setEdge(n4, n7);

		return g1;
	}
	
	
	private IGraphAccessor generateSampleG12() {
		SimpleGraphAccessor g1 = new SimpleGraphAccessor();

		GraphNode n1 = new GraphNode("Person");
		GraphNode n2 = new GraphNode("fname");
		GraphNode n3 = new GraphNode("Family");
		GraphNode n4 = new GraphNode("lastname");
		GraphNode n5 = new GraphNode("Address");
		GraphNode n6 = new GraphNode("street");
		GraphNode n7 = new GraphNode("city");
		GraphNode n8 = new GraphNode("country");

		g1.setEdge(n1, n2);
		g1.setEdge(n3, n4);
		g1.setEdge(n1, n3);
		g1.setEdge(n3, n5);
		g1.setEdge(n5, n6);
		g1.setEdge(n5, n7);
		g1.setEdge(n5, n8);
		
		return g1;
	}
	
	
	private IGraphAccessor generateSampleG1() {
		SimpleGraphAccessor g1 = new SimpleGraphAccessor();

		GraphNode n1 = new GraphNode("1");
		GraphNode n2 = new GraphNode("2");
		GraphNode n3 = new GraphNode("3");
		GraphNode n4 = new GraphNode("4");
		GraphNode n5 = new GraphNode("5");
		GraphNode n6 = new GraphNode("6");
		GraphNode n7 = new GraphNode("7");
		GraphNode n8 = new GraphNode("8");
		GraphNode n9 = new GraphNode("9");
		GraphNode n10 = new GraphNode("10");
		GraphNode n11 = new GraphNode("11");
		GraphNode n12 = new GraphNode("12");
		GraphNode n13 = new GraphNode("13");
		GraphNode n14 = new GraphNode("14");
		GraphNode n15 = new GraphNode("15");
		GraphNode n16 = new GraphNode("16");
		GraphNode n17 = new GraphNode("17");

		g1.setEdge(n1, n2);
		g1.setEdge(n1, n3);
		g1.setEdge(n2, n4);
		g1.setEdge(n2, n5);
		g1.setEdge(n2, n6);
		g1.setEdge(n3, n6);
		g1.setEdge(n3, n7);
		g1.setEdge(n4, n8);
		g1.setEdge(n6, n9);
		g1.setEdge(n7, n10);
		g1.setEdge(n7, n11);
		g1.setEdge(n7, n12);
		g1.setEdge(n8, n13);
		g1.setEdge(n9, n13);
		g1.setEdge(n9, n14);
		g1.setEdge(n9, n15);
		g1.setEdge(n10, n15);
		g1.setEdge(n10, n16);
		g1.setEdge(n11, n16);
		g1.setEdge(n12, n17);
		g1.setEdge(n17, n16);

		return g1;
	}

	private IGraphAccessor generateSampleG2() {
		SimpleGraphAccessor g2 = new SimpleGraphAccessor();

		GraphNode n1 = new GraphNode("1");
		GraphNode n2 = new GraphNode("5");
		GraphNode n3 = new GraphNode("3");
		GraphNode n4 = new GraphNode("10");
		GraphNode n5 = new GraphNode("11");
		GraphNode n6 = new GraphNode("12");
		GraphNode n7 = new GraphNode("2");
		GraphNode n8 = new GraphNode("17");
		GraphNode n9 = new GraphNode("8");
		GraphNode n10 = new GraphNode("4");
		GraphNode n11 = new GraphNode("9");

		g2.setEdge(n1, n2);
		g2.setEdge(n1, n3);
		g2.setEdge(n2, n4);
		g2.setEdge(n2, n5);
		g2.setEdge(n2, n6);
		g2.setEdge(n3, n6);
		g2.setEdge(n3, n7);
		g2.setEdge(n4, n10);
		g2.setEdge(n5, n10);
		g2.setEdge(n6, n8);
		g2.setEdge(n7, n9);
		g2.setEdge(n8, n10);
		g2.setEdge(n8, n11);
		g2.setEdge(n9, n11);

		return g2;
	}

	private IGraphAccessor generateSampleG3() {
		SimpleGraphAccessor g3 = new SimpleGraphAccessor();

		GraphNode n1 = new GraphNode("A");
		GraphNode n2 = new GraphNode("B");
		GraphNode n3 = new GraphNode("C");
		GraphNode n4 = new GraphNode("D");
		GraphNode n5 = new GraphNode("E");
		GraphNode n6 = new GraphNode("F");
		GraphNode n7 = new GraphNode("G");
		GraphNode n8 = new GraphNode("H");
		GraphNode n9 = new GraphNode("I");
		GraphNode n10 = new GraphNode("J");
		GraphNode n11 = new GraphNode("K");

		g3.setEdge(n1, n2); // A-B
		g3.setEdge(n1, n3); // A-C
		g3.setEdge(n2, n4); // B-D
		g3.setEdge(n2, n5); // B-E
		g3.setEdge(n2, n6); // B-F
		g3.setEdge(n3, n6); // C-F
		g3.setEdge(n3, n7); // C-G
		g3.setEdge(n6, n8); // F-H
		g3.setEdge(n6, n9); // F-I
		g3.setEdge(n6, n10); // F-J
		g3.setEdge(n6, n11); // F-K
		g3.setEdge(n7, n8); // G-H
		g3.setEdge(n7, n9); // G-I
		g3.setEdge(n7, n10); // G-J
		g3.setEdge(n7, n11); // G-K

		return g3;
	}

	private IGraphAccessor generateSampleG4() {
		SimpleGraphAccessor g4 = new SimpleGraphAccessor();

		GraphNode n1 = new GraphNode("a");
		GraphNode n2 = new GraphNode("b");
		GraphNode n3 = new GraphNode("c");
		GraphNode n4 = new GraphNode("d");
		GraphNode n5 = new GraphNode("e");
		GraphNode n6 = new GraphNode("f");
		GraphNode n7 = new GraphNode("g");
		GraphNode n8 = new GraphNode("h");
		GraphNode n9 = new GraphNode("i");
		GraphNode n10 = new GraphNode("j");
		GraphNode n11 = new GraphNode("k");
		GraphNode n12 = new GraphNode("l");

		g4.setEdge(n1, n2); // a-b
		g4.setEdge(n1, n3); // a-c
		g4.setEdge(n1, n4); // a-d
		g4.setEdge(n1, n5); // a-e
		g4.setEdge(n2, n6); // b-f
		g4.setEdge(n2, n7); // b-g
		g4.setEdge(n2, n8); // b-h
		g4.setEdge(n3, n9); // c-i
		g4.setEdge(n4, n12); // d-l
		g4.setEdge(n5, n10); // e-j
		g4.setEdge(n5, n11); // e-k
		g4.setEdge(n9, n12); // i-l

		return g4;
	}
}