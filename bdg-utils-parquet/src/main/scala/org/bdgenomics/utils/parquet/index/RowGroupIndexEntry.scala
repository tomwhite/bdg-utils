/**
 * Licensed to Big Data Genomics (BDG) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The BDG licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bdgenomics.utils.parquet.index

import org.bdgenomics.utils.parquet.rdd.{ ParquetRowGroup, Footer }

/**
 * Any class which represents an entry (line?) in an index file should extend this class.
 *
 * @param path The location of the indexed row group's parquet file.
 * @param index The index of the row group in the parquet file.
 */
class RowGroupIndexEntry(path: String, index: Int) {

  assert(index >= 0, "Negative row-group indices are not allowed.")

  def parquetFilePath(): String = path
  def getRowGroup(footer: Footer): ParquetRowGroup = footer.rowGroups(index)
}

