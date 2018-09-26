/*
 * Copyright (c) 2018 HERE Europe B.V.
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
package com.here.account.auth.provider;

import com.here.account.oauth2.AccessTokenRequest;
import com.here.account.oauth2.ClientAuthorizationRequestProvider;
import com.here.account.oauth2.ClientCredentialsGrantRequest;
import com.here.account.util.Clock;

public abstract class ClientCredentialsGrantRequestProvider
        extends AbstractClientAuthorizationRequestProvider
        implements ClientAuthorizationRequestProvider {

    protected ClientCredentialsGrantRequestProvider(Clock clock) {
        super(clock);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccessTokenRequest getNewAccessTokenRequest() {
        return new ClientCredentialsGrantRequest();
    }
    
}