/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.serde;

import com.facebook.presto.tuple.TupleInfo;
import io.airlift.slice.SliceInput;
import io.airlift.slice.SliceOutput;

import static com.google.common.base.Preconditions.checkNotNull;

public final class TupleInfoSerde
{
    private TupleInfoSerde()
    {
    }

    public static void writeTupleInfo(SliceOutput sliceOutput, TupleInfo tupleInfo)
    {
        checkNotNull(tupleInfo, "tupleInfo is null");
        checkNotNull(sliceOutput, "sliceOutput is null");

        sliceOutput.writeByte(tupleInfo.getType().ordinal());
    }

    public static TupleInfo readTupleInfo(SliceInput sliceInput)
    {
        checkNotNull(sliceInput, "sliceInput is null");

        return new TupleInfo(TupleInfo.Type.values()[sliceInput.readUnsignedByte()]);
    }
}
