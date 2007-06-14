package abc.tm.weaving.weaver.tmanalysis.mustalias;

import java.util.Set;

import abc.tm.weaving.aspectinfo.TraceMatch;
import abc.tm.weaving.weaver.tmanalysis.util.Naming;

/**
 * Generic interface for a flow-sensitive analysis for static tracematch optimizations.
 *
 * @author Eric Bodden
 */
public interface TMFlowAnalysis {
	
	/**
	 * @return returns the associated tracematch
	 */
	public TraceMatch getTracematch();

	/**
	 * Registers the shadows passed in as active, i.e. to be retained.
	 * Those shadows are crucial for the correct working of the tracematch.
	 * <i>This method is only to be used from within the analysis.</i>
	 * @param history a set of unique shadow IDs
	 * @see Naming#uniqueShadowID(String, int)
	 * @see Naming#uniqueShadowID(String, String, int)
	 */
	public void registerActiveShadows(Set history);

	/**
	 * Returns the set of <i>active</i> shadows, i.e. shadows being used in order
	 * to reach a final state.
	 * This is the union of all shadow IDs which were registered using {@link #registerActiveShadows(Set)}.
	 * @return a list of shadow IDs (int) for all active shadows
	 * @see Naming#uniqueShadowID(String, int)
	 * @see Naming#uniqueShadowID(String, String, int)
	 */
	public Set getActiveShadows();

}