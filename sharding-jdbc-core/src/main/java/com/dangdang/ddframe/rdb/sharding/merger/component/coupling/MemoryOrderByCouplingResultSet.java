/**
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.rdb.sharding.merger.component.coupling;

import java.sql.ResultSet;
import java.util.List;

import com.dangdang.ddframe.rdb.sharding.jdbc.adapter.AbstractDelegateResultSetAdapter;
import com.dangdang.ddframe.rdb.sharding.merger.common.MemoryOrderByResultSet;
import com.dangdang.ddframe.rdb.sharding.merger.component.CouplingResultSet;
import com.dangdang.ddframe.rdb.sharding.parser.result.merger.OrderByColumn;

/**
 * 基于内存的全排序.
 *
 * @author gaohongtao
 */
public class MemoryOrderByCouplingResultSet extends AbstractDelegateResultSetAdapter implements CouplingResultSet {
    
    private final List<OrderByColumn> expectOrderList;
    
    public MemoryOrderByCouplingResultSet(final List<OrderByColumn> expectOrderList) {
        this.expectOrderList = expectOrderList;
    }
    
    @Override
    public void inject(final ResultSet preResultSet) {
        setDelegatedResultSet(new MemoryOrderByResultSet(preResultSet, expectOrderList));
    }
}
