package com.lxk.http;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 测试 Java 发 http 请求
 *
 * @author lxk on 2017/12/1
 */
public class Main {
    private static final int SOCKET_TIMEOUT = 3000;
    private static final int CONNECT_TIMEOUT = 3000;
    private static final String CHARSET = "utf-8";
    private static final String USER = "utf-8";
    private static final String PASSWORD = "utf-8";
    private static final String UPDATE_PROBE_SETTING_FILE_CLIENT_PATH = "probe/updateProbeSettingFileClient";
    private static final String LOGIN_PATH = "login";

    public static void main(String[] args) {
        String ip = "192.168.100.212";
        Integer port = 27001;
        Client client = new Client("http://" + ip + ":" + port, SOCKET_TIMEOUT, CONNECT_TIMEOUT, CHARSET);

        testPost(client);
    }

    private static void testPost(Client client) {
        Map<String, String> params = Maps.newHashMap();
        params.put("probe", getJsonProbe());
        params.put("filePath", "d:a-lxk-new-text.inc");
        try {
            if (!client.isLogin()) {
                client.login(LOGIN_PATH + "?user=" + USER + "&pwd=" + PASSWORD);
            }
            Object o = client.httpFormPost(UPDATE_PROBE_SETTING_FILE_CLIENT_PATH, params);
            if (o != null) {
                System.out.println(o.toString());
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得json类型的探针数据
     */
    private static String getJsonProbe() {
        return "{\n" +
                "    \"id\": null,\n" +
                "    \"moduleId\": null,\n" +
                "    \"map\": {\n" +
                "        \"genericResponseTime\": {\n" +
                "            \"name\": \"genericResponseTime\",\n" +
                "            \"properties\": [\n" +
                "                {\n" +
                "                    \"type\": null,\n" +
                "                    \"key\": \"SessionHashSize\",\n" +
                "                    \"value\": 7919,\n" +
                "                    \"equalType\": \"Equal\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"type\": null,\n" +
                "                    \"key\": \"Cutoff\",\n" +
                "                    \"value\": 300,\n" +
                "                    \"equalType\": \"Equal\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ruleList\": [\n" +
                "                {\n" +
                "                    \"name\": \"pingan\",\n" +
                "                    \"properties\": [\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Summarise_by\",\n" +
                "                            \"value\": \"port\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"WaitforSYN\",\n" +
                "                            \"value\": 0,\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"BiDirection\",\n" +
                "                            \"value\": 0,\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"ClientRSTasFIN\",\n" +
                "                            \"value\": 1,\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Server_ip\",\n" +
                "                            \"value\": \"21.64.68.79\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Server_port\",\n" +
                "                            \"value\": \"any\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Client_ip\",\n" +
                "                            \"value\": \"any\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Client_port\",\n" +
                "                            \"value\": \"any\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Extlib\",\n" +
                "                            \"value\": \"./plugins/customized_protobuff.so\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"transactionList\": [\n" +
                "                        {\n" +
                "                            \"name\": \"POST_PB1\",\n" +
                "                            \"properties\": [\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Content\",\n" +
                "                                    \"value\": \"POST \\\\/mtp-web\",\n" +
                "                                    \"equalType\": \"Regex\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Postprecedure\",\n" +
                "                                    \"value\": 0,\n" +
                "                                    \"equalType\": \"Equal\"\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"transRef\": {\n" +
                "                                \"properties\": [\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Offset\",\n" +
                "                                        \"value\": 0,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Depth\",\n" +
                "                                        \"value\": 6000,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"POST \\\\/mtp-web(\\\\S*)\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"PATH\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"POST \\\\/mtp-web(\\\\S*)ss\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"PATH\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCode\": {\n" +
                "                                \"properties\": [\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Offset\",\n" +
                "                                        \"value\": 0,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Depth\",\n" +
                "                                        \"value\": 90,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"^HTTP/1.1 (\\\\d+)\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"HTTP_RETCODE\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCodeX\": null\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"POST_PB2\",\n" +
                "                            \"properties\": [\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Content\",\n" +
                "                                    \"value\": \"POST \\\\/mtp-web2\",\n" +
                "                                    \"equalType\": \"Regex\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Postprecedure\",\n" +
                "                                    \"value\": 0,\n" +
                "                                    \"equalType\": \"Equal\"\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"transRef\": {\n" +
                "                                \"properties\": [\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Offset\",\n" +
                "                                        \"value\": 0,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Depth\",\n" +
                "                                        \"value\": 6000,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"POST \\\\/mtp-web(\\\\S*)\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"PATH\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCode\": {\n" +
                "                                \"properties\": [\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Offset\",\n" +
                "                                        \"value\": 0,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Depth\",\n" +
                "                                        \"value\": 90,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"^HTTP/1.1 (\\\\d+)\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"HTTP_RETCODE\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCodeX\": null\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"pingan_2\",\n" +
                "                    \"properties\": [\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Summarise_by\",\n" +
                "                            \"value\": \"port\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"WaitforSYN\",\n" +
                "                            \"value\": 0,\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"BiDirection\",\n" +
                "                            \"value\": 0,\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"ClientRSTasFIN\",\n" +
                "                            \"value\": 1,\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Server_ip\",\n" +
                "                            \"value\": \"21.64.68.79\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Server_port\",\n" +
                "                            \"value\": \"8080\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Client_ip\",\n" +
                "                            \"value\": \"any\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Client_port\",\n" +
                "                            \"value\": \"any\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Extlib\",\n" +
                "                            \"value\": \"./plugins/customized_protobuff.so\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"transactionList\": [\n" +
                "                        {\n" +
                "                            \"name\": \"POST_PB3\",\n" +
                "                            \"properties\": [\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Content\",\n" +
                "                                    \"value\": \"POST \\\\/mtp-web3\",\n" +
                "                                    \"equalType\": \"Regex\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Postprecedure\",\n" +
                "                                    \"value\": 0,\n" +
                "                                    \"equalType\": \"Equal\"\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"transRef\": {\n" +
                "                                \"properties\": [\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Offset\",\n" +
                "                                        \"value\": 0,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Depth\",\n" +
                "                                        \"value\": 6000,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"POST \\\\/mtp-web(\\\\S*)\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"PATH\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCode\": {\n" +
                "                                \"properties\": [\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Offset\",\n" +
                "                                        \"value\": 0,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Depth\",\n" +
                "                                        \"value\": 90,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"^HTTP/1.1 (\\\\d+)\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"HTTP_RETCODE\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCodeX\": null\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"POST_PB4\",\n" +
                "                            \"properties\": [\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Content\",\n" +
                "                                    \"value\": \"POST \\\\/mtp-web4\",\n" +
                "                                    \"equalType\": \"Regex\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Postprecedure\",\n" +
                "                                    \"value\": 0,\n" +
                "                                    \"equalType\": \"Equal\"\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"transRef\": {\n" +
                "                                \"properties\": [\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Offset\",\n" +
                "                                        \"value\": 0,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Depth\",\n" +
                "                                        \"value\": 6000,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"POST \\\\/mtp-web(\\\\S*)\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"PATH\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCode\": {\n" +
                "                                \"properties\": [\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Offset\",\n" +
                "                                        \"value\": 0,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Depth\",\n" +
                "                                        \"value\": 90,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"^HTTP/1.1 (\\\\d+)\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"HTTP_RETCODE\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCodeX\": {\n" +
                "                                \"properties\": [\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Offset\",\n" +
                "                                        \"value\": 0,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"type\": null,\n" +
                "                                        \"key\": \"Depth\",\n" +
                "                                        \"value\": 90,\n" +
                "                                        \"equalType\": \"Equal\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"^HTTP/1.1 (\\\\d+)\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"HTTP_RETCODE\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"ASYNC\": {\n" +
                "            \"name\": \"ASYNC\",\n" +
                "            \"properties\": [],\n" +
                "            \"ruleList\": [\n" +
                "                {\n" +
                "                    \"name\": \"CITIC_LC\",\n" +
                "                    \"properties\": [\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Server_ip\",\n" +
                "                            \"value\": \"any\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Server_port\",\n" +
                "                            \"value\": \"3421\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Client_port\",\n" +
                "                            \"value\": \"any\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"Client_ip\",\n" +
                "                            \"value\": \"any\",\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"WaitforSYN\",\n" +
                "                            \"value\": 0,\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"BiDirection\",\n" +
                "                            \"value\": 1,\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\": null,\n" +
                "                            \"key\": \"HeaderLen\",\n" +
                "                            \"value\": 80,\n" +
                "                            \"equalType\": \"Equal\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"transactionList\": [\n" +
                "                        {\n" +
                "                            \"name\": \"lcpt_request\",\n" +
                "                            \"properties\": [\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Content\",\n" +
                "                                    \"value\": \"(\\\\d{6})<\\\\?xml version[\\\\s\\\\S]*?<ROOT\\\\s*type=\\\\\\\"request\\\\\\\">\",\n" +
                "                                    \"equalType\": \"Regex\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Expect_data_bytes\",\n" +
                "                                    \"value\": \"$1i\",\n" +
                "                                    \"equalType\": \"Equal\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"LengthLV\",\n" +
                "                                    \"value\": 6,\n" +
                "                                    \"equalType\": \"Equal\"\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"transRef\": {\n" +
                "                                \"properties\": [],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<stdmsgtype>(\\\\S*?)<\\\\/stdmsgtype>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"stdmsgtype\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<stdprocode>(\\\\S*?)<\\\\/stdprocode>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"stdprocode\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"},{\\\\\\\"name\\\\\\\":\\\\\\\"TT\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<stdtermid>(\\\\S*?)<\\\\/stdtermid>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"stdtermid\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<stdtermtrc>(\\\\S*?)</stdtermtrc>[\\\\s\\\\S]*?<stdrefnum>(\\\\S*?)<\\\\/stdrefnum>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"stdtermtrc-stdrefnum\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1-$2\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<stdrefnum>(\\\\S*)<\\\\/stdrefnum>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"stdrefnum\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<stdtranamt>([^<>]+?)</stdtranamt>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"amount\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"a\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<std400mgid>(\\\\S*?)<\\\\/std400mgid>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"std400mgid\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCode\": null,\n" +
                "                            \"retCodeX\": null\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"lcpt_response\",\n" +
                "                            \"properties\": [\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Content\",\n" +
                "                                    \"value\": \"(\\\\d{6})<\\\\?xml[\\\\s\\\\S]*?\\\\x0a<ROOT><stdmsgtype>\",\n" +
                "                                    \"equalType\": \"Regex\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"Expect_data_bytes\",\n" +
                "                                    \"value\": \"$1i\",\n" +
                "                                    \"equalType\": \"Equal\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"type\": null,\n" +
                "                                    \"key\": \"LengthLV\",\n" +
                "                                    \"value\": 6,\n" +
                "                                    \"equalType\": \"Equal\"\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"transRef\": {\n" +
                "                                \"properties\": [],\n" +
                "                                \"extractorList\": [\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<stdmsgtype>(\\\\S*?)<\\\\/stdmsgtype>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"stdmsgtype\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<stdtermid>(\\\\S*?)<\\\\/stdtermid>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"stdtermid\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<stdtermtrc>(\\\\S*?)</stdtermtrc>[\\\\s\\\\S]*?<stdrefnum>(\\\\S*?)<\\\\/stdrefnum>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"stdtermtrc-stdrefnum\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1-$2\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"ref\": \"<std400mgid>(\\\\S*?)<\\\\/std400mgid>\",\n" +
                "                                        \"param\": \"[{\\\\\\\"name\\\\\\\":\\\\\\\"std400mgid\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"},{\\\\\\\"name\\\\\\\":\\\\\\\"RC\\\\\\\", \\\\\\\"pattern\\\\\\\":\\\\\\\"$1\\\\\\\", \\\\\\\"type\\\\\\\":\\\\\\\"s\\\\\\\"}]\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            \"retCode\": null,\n" +
                "                            \"retCodeX\": null\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

}
