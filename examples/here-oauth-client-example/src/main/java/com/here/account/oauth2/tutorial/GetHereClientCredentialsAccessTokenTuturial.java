/*
 * Copyright (c) 2016 HERE Europe B.V.
 * 
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
package com.here.account.oauth2.tutorial;

import java.io.File;

import com.here.account.auth.OAuth1ClientCredentialsProvider;
import com.here.account.http.apache.ApacheHttpClientProvider;
import com.here.account.oauth2.AccessTokenResponse;
import com.here.account.oauth2.ClientCredentialsGrantRequest;
import com.here.account.oauth2.Fresh;
import com.here.account.oauth2.HereAccount;
import com.here.account.oauth2.TokenEndpoint;

public class GetHereClientCredentialsAccessTokenTuturial {

    public static void main(String[] argv) {
        usage(argv);
        try {
            File file = new File(argv[0]);
            TokenEndpoint tokenEndpoint = HereAccount.getTokenEndpoint(
                    ApacheHttpClientProvider.builder().build(), 
                    new OAuth1ClientCredentialsProvider.FromFile(file));
            Fresh<AccessTokenResponse> fresh = 
                    tokenEndpoint.requestAutoRefreshingToken(new ClientCredentialsGrantRequest());
            String accessToken = fresh.get().getAccessToken();
            System.out.println("HERE Access Token: " + accessToken.substring(0, 25) + "..." + accessToken.substring(accessToken.length() - 4));
        } catch (Exception e) {
            System.err.println("trouble getting Here client_credentials Access Token: " + e);
            e.printStackTrace();
            System.exit(2);
        }
    }
    
    public static void usage(String[] argv) {
        if (null == argv || 1 != argv.length) {
            System.err.println("Usage: java "
                    + GetHereClientCredentialsAccessTokenTuturial.class.getName()
                    + " <path_to_credentials_property_file>");
            System.exit(1);
        }
    }

}