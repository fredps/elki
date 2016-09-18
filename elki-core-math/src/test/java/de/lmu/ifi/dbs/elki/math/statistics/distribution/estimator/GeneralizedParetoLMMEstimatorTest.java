package de.lmu.ifi.dbs.elki.math.statistics.distribution.estimator;

import static org.junit.Assert.fail;

/*
 This file is part of ELKI:
 Environment for Developing KDD-Applications Supported by Index-Structures

 Copyright (C) 2016
 Ludwig-Maximilians-Universität München
 Lehr- und Forschungseinheit für Datenbanksysteme
 ELKI Development Team

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.junit.Test;

import de.lmu.ifi.dbs.elki.math.statistics.distribution.GeneralizedParetoDistribution;
import de.lmu.ifi.dbs.elki.utilities.datastructures.arraylike.DoubleArrayAdapter;

/**
 * Regression test the estimation for the GeneralizedParetoLMM distribution.
 * 
 * @author Erich Schubert
 */
public class GeneralizedParetoLMMEstimatorTest extends AbstractDistributionEstimatorTest {
  @Test
  public void testEstimator() {
    final GeneralizedParetoLMMEstimator est = GeneralizedParetoLMMEstimator.STATIC;
    load("gpd.ascii.gz");
    double[] data = this.data.get("random_01_05_01");
    GeneralizedParetoDistribution dist = est.estimate(data, DoubleArrayAdapter.STATIC);
    assertStat("mu", dist.getMu(), 0.1, -0.19465696594915963);
    assertStat("sigma", dist.getSigma(), 0.5, 0.09234727159645928);
    assertStat("xi", dist.getXi(), 0.1, 0.12674078147717688);
    fail("Pretty large estimation errors!");
  }
}