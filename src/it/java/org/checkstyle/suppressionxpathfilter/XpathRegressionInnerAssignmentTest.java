///////////////////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code and other text files for adherence to a set of rules.
// Copyright (C) 2001-2025 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
///////////////////////////////////////////////////////////////////////////////////////////////

package org.checkstyle.suppressionxpathfilter;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.checks.coding.InnerAssignmentCheck;

public class XpathRegressionInnerAssignmentTest extends AbstractXpathTestSupport {

    private final String checkName = InnerAssignmentCheck.class.getSimpleName();

    @Override
    protected String getCheckName() {
        return checkName;
    }

    @Test
    public void testInnerAssignment() throws Exception {
        final File fileToProcess = new
                File(getPath("InputXpathInnerAssignment.java"));

        final DefaultConfiguration moduleConfig = createModuleConfig(InnerAssignmentCheck.class);

        final String[] expectedViolation = {
            "7:15: " + getCheckMessage(InnerAssignmentCheck.class, InnerAssignmentCheck.MSG_KEY),
        };

        final List<String> expectedXpathQueries = List.of(
                "/COMPILATION_UNIT"
                        + "/CLASS_DEF[./IDENT[@text='InputXpathInnerAssignment']]"
                        + "/OBJBLOCK/METHOD_DEF[./IDENT[@text='testMethod']]"
                        + "/SLIST/EXPR/ASSIGN[./IDENT[@text='a']]/ASSIGN[./IDENT[@text='b']]"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation, expectedXpathQueries);
    }

    @Test
    public void testArrays() throws Exception {
        final File fileToProcess = new
                File(getPath("InputXpathInnerAssignmentArrays.java"));

        final DefaultConfiguration moduleConfig = createModuleConfig(InnerAssignmentCheck.class);

        final String[] expectedViolation = {
            "6:55: " + getCheckMessage(InnerAssignmentCheck.class, InnerAssignmentCheck.MSG_KEY),
        };

        final List<String> expectedXpathQueries = Arrays.asList(
                "/COMPILATION_UNIT"
                + "/CLASS_DEF[./IDENT[@text='InputXpathInnerAssignmentArrays']]"
                + "/OBJBLOCK/METHOD_DEF[./IDENT[@text='testMethod']]"
                + "/SLIST/VARIABLE_DEF[./IDENT[@text='doubleArray']]"
                + "/ASSIGN/EXPR/LITERAL_NEW/ARRAY_INIT/EXPR[./ASSIGN/IDENT[@text='myDouble']]",
                "/COMPILATION_UNIT"
                + "/CLASS_DEF[./IDENT[@text='InputXpathInnerAssignmentArrays']]"
                + "/OBJBLOCK/METHOD_DEF[./IDENT[@text='testMethod']]/"
                + "SLIST/VARIABLE_DEF[./IDENT[@text='doubleArray']]"
                + "/ASSIGN/EXPR/LITERAL_NEW/ARRAY_INIT/EXPR/ASSIGN[./IDENT[@text='myDouble']]"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation, expectedXpathQueries);
    }
}
