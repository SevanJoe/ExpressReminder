/*
 * Copyright (c) 2015. Sevan Joe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sevanjoe.expressreminder.model.bean.company;

import java.util.Arrays;

/**
 * Created by Sevan Joe on 2015/3/30 0030.
 */
public class SposterCompany extends Company {

    private static final String[] sposterNumberList = {"10690329010055", "10657109010055"};

    public SposterCompany() {
        this.id = 1;
        this.name = "速递易";
        this.numberList = Arrays.asList(sposterNumberList);
    }
}
