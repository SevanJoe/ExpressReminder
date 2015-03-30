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

package com.sevanjoe.expressreminder.sms;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.sevanjoe.expressreminder.model.bean.Sms;
import com.sevanjoe.expressreminder.model.bean.company.CompanyHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sevan Joe on 3/24/2015.
 */
public class SmsHelper {
    private static SmsHelper instance;

    private Context context;

    public static SmsHelper getInstance() {
        if (null == instance) {
            instance = new SmsHelper();
        }
        return instance;
    }

    private SmsHelper() {

    }

    public void init(Context context) {
        this.context = context;
    }

    public List<Sms> loadExpressSms() {
        List<Sms> smsList = new ArrayList<>();
        Cursor cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"), null,
                "address=?", CompanyHelper.getInstance().getCompanyNumberList(), "date DESC");
        int addressIndex = cursor.getColumnIndex("address");
        int bodyIndex = cursor.getColumnIndex("body");
        int dateIndex = cursor.getColumnIndex("date");
        if (addressIndex >= 0 && bodyIndex >= 0 && dateIndex >= 0) {
            if (cursor.moveToFirst()) {
                do {
                    Sms sms = new Sms();
                    String address = cursor.getString(addressIndex);
                    String body = cursor.getString(bodyIndex);
                    String date = cursor.getString(dateIndex);
                    sms.setAddress(address);
                    sms.setBody(body);
                    sms.setDate(date);
                    smsList.add(sms);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();

        return smsList;
    }
}
