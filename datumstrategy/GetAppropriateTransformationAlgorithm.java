package datumstrategy;

// package Classes;

/**
 *  @class GetAppropriateTransformationAlgorithm
 *  @remark last refactored 11.12.2017 by Eva Majer <br/>
 *  <ul>
 *   <li>adaptions for ControlParms Singleton</li>
 *  </ul>
 */

import params.ControlParms;

public class GetAppropriateTransformationAlgorithm {

	public static TransformationStrategy getStrategy() {

		ControlParms control = ControlParms.getInstance();

		if (control.getKindoftrafo() == null) // kein Wechsel des Datums
			return new MockStrategy();
		else if (control.getKindoftrafo().equals("mol_stand"))
			return MolodenskiiTransformationStandard.getInstance();
		else if (control.getKindoftrafo().equals("mol_abridged"))
			return MolodenskiiTransformationAbridged.getInstance();
		else if (control.getKindoftrafo().equals("3D_infin"))
			return new SpatialSimilarityTransformationInfin();
		else if (control.getKindoftrafo().equals("3D_trig"))
			return new SpatialSimilarityTransformationTrig();
		return null;
	}
}
