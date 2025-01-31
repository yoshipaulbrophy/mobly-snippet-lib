/*
 * Copyright (C) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.android.mobly.snippet.rpc;

import android.content.Context;
import com.google.android.mobly.snippet.manager.ReflectionSnippetManagerFactory;
import com.google.android.mobly.snippet.manager.SnippetManagerFactory;
import java.io.IOException;

public class AndroidProxy {

    private final JsonRpcServer mJsonRpcServer;
    private final SnippetManagerFactory mSnippetManagerFactory;

    public AndroidProxy(Context context) {
        mSnippetManagerFactory = new ReflectionSnippetManagerFactory(context);
        mJsonRpcServer = new JsonRpcServer(mSnippetManagerFactory);
    }

    public void startLocal(int port) throws IOException {
        mJsonRpcServer.startLocal(port);
    }

    public int getPort() {
        return mJsonRpcServer.getPort();
    }
}
