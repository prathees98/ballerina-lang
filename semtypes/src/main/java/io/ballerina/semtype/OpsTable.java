/*
 *  Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package io.ballerina.semtype;

import io.ballerina.semtype.typeops.BooleanOps;
import io.ballerina.semtype.typeops.ErrorOps;
import io.ballerina.semtype.typeops.FloatOps;
import io.ballerina.semtype.typeops.FunctionOps;
import io.ballerina.semtype.typeops.IntOps;
import io.ballerina.semtype.typeops.ListTypeRoOps;
import io.ballerina.semtype.typeops.ListTypeRwOps;
import io.ballerina.semtype.typeops.MappingRoOps;
import io.ballerina.semtype.typeops.MappingRwOps;
import io.ballerina.semtype.typeops.StringOps;
import io.ballerina.semtype.typeops.UniformTypeOpsPanicImpl;

/**
 * Lookup table containing subtype ops for each uniform type indexed by uniform type code.
 *
 * @since 2.0.0
 */
public class OpsTable {
    private static final UniformTypeOpsPanicImpl PANIC_IMPL = new UniformTypeOpsPanicImpl();
    static final UniformTypeOps[] OPS;

    static {
        int i = 0;
        OPS = new UniformTypeOps[23];
        OPS[i++] = PANIC_IMPL;          // nil
        OPS[i++] = new BooleanOps();    // boolean
        OPS[i++] = new ListTypeRoOps(); // RO list
        OPS[i++] = new MappingRoOps();  // RO mapping
        OPS[i++] = PANIC_IMPL;          // RO table
        OPS[i++] = PANIC_IMPL;          // RO xml
        OPS[i++] = PANIC_IMPL;          // RO object
        OPS[i++] = new IntOps();        // int
        OPS[i++] = new FloatOps();      // float
        OPS[i++] = PANIC_IMPL;          // decimal
        OPS[i++] = new StringOps();     // string
        OPS[i++] = new ErrorOps();      // error
        OPS[i++] = new FunctionOps();   // function
        OPS[i++] = PANIC_IMPL;          // typedesc
        OPS[i++] = PANIC_IMPL;          // handle
        OPS[i++] = PANIC_IMPL;          // unused
        OPS[i++] = PANIC_IMPL;          // RW future
        OPS[i++] = PANIC_IMPL;          // RW stream
        OPS[i++] = new ListTypeRwOps(); // RW list
        OPS[i++] = new MappingRwOps();  // RW mapping
        OPS[i++] = PANIC_IMPL;          // RW table
        OPS[i++] = PANIC_IMPL;          // RW xml
        OPS[i] = PANIC_IMPL;            // RW object
    }
}
