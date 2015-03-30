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

import java.util.List;

/**
 * Created by Sevan Joe on 3/30/2015.
 */
public abstract class Company {
    protected int id;
    protected String name;
    protected List<String> numberList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<String> numberList) {
        this.numberList = numberList;
    }
}
