/*
 * Copyright (c) 2007-present Sonatype, Inc. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.example.ssl;

import org.sonatype.goodies.httpfixture.server.fluent.Server;

public class HttpsServer
{
  public static void main(String[] args) throws Exception {
    if (args.length < 5) {
      System.err.println("Usage: HttpsServer <port> <keystore> <keystore password> <truststore> <truststore password>");
    }
    else {
      System.out.println(String.format("Starting server...%n"
          + "port: %s,%n"
          + "keystore: %s,%n"
          + "keystore password: %s,%n"
          + "truststore: %s,%n"
          + "truststore password: %s", args));
      Server server = Server.withPort(Integer.parseInt(args[0]))
          .withKeystore(args[1], args[2])
          .withTruststore(args[3], args[4])
          .requireClientAuth()
          .start();
      System.out.println("Server port: " + server.getPort());
    }
  }
}
