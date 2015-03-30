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

/**
 * Created by Sevan Joe on 2015/3/30 0030.
 */
public class SposterCompanyFactory implements CompanyFactory {
    private static SposterCompanyFactory instance;

    public static SposterCompanyFactory getInstance() {
        if (null == instance) {
            instance = new SposterCompanyFactory();
        }
        return instance;
    }

    private SposterCompanyFactory() {

    }

    @Override
    public Company createCompany() {
        return new SposterCompany();
    }
}
