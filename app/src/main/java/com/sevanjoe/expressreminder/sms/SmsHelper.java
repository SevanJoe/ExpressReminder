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
import com.sevanjoe.library.utils.LogUtil;

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
                "address=?", new String[]{"11183"}, "date desc");
        int addressIndex = cursor.getColumnIndexOrThrow("address");
        int bodyIndex = cursor.getColumnIndexOrThrow("body");
        if (addressIndex >= 0 && bodyIndex >= 0) {
            if (cursor.moveToFirst()) {
                do {
                    Sms sms = new Sms();
                    String address = cursor.getString(addressIndex);
                    String body = cursor.getString(bodyIndex);
                    sms.setAddress(address);
                    sms.setBody(body);
                    smsList.add(sms);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();

        return smsList;
    }
}
