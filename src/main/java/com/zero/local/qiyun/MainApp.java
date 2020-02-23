package com.zero.local.qiyun;


/**
 * @author yechangfeng
 * @date 2018/12/14
 */
public class MainApp {
    public static void main(String[] args) {
        String accessKey = "7lJfNca1z6F7inrSRMvdhpyJa93FFnzqadw3UGTh";
        String secretKey = "PW_HKJjwB8X8ovnOV9PObTC81sIw522MIYjzmJba";
        //房间helloWorld     名字testUser1      过期时间2018/12/15 00:00:00
        String token1 = "7lJfNca1z6F7inrSRMvdhpyJa93FFnzqadw3UGTh:RfNPGV1pmjXbLbSvoVuJZgoqot4=:eyJhcHBJZCI6ImR3NG50MGZwMyIsInJvb21OYW1lIjoiaGVsbG9Xb3JsZCIsInVzZXJJZCI6InRlc3RVc2VyMSIsImV4cGlyZUF0IjoxNTQ0ODAzMjAwLCJwZXJtaXNzaW9uIjoidXNlciJ9";
        //房间helloWorld     名字testUser2      过期时间2018/12/15 00:00:00
        String token2 = "7lJfNca1z6F7inrSRMvdhpyJa93FFnzqadw3UGTh:6n3lhqOY8k7BCq8TGrugHklDnP0=:eyJhcHBJZCI6ImR3NG50MGZwMyIsInJvb21OYW1lIjoiaGVsbG9Xb3JsZCIsInVzZXJJZCI6InRlc3RVc2VyMiIsImV4cGlyZUF0IjoxNTQ0ODAzMjAwLCJwZXJtaXNzaW9uIjoidXNlciJ9";
        String token1Test = "7lJfNca1z6F7inrSRMvdhpyJa93FFnzqadw3UGTh:RfNPGV1pmjXbLbSvoVuJZgoqot4=:eyJhcHBJZCI6ImR3NG50MGZwMyIsInJvb21OYW1lIjoiaGVsbG9Xb3JsZCIsInVzZXJJZCI6InRlc3RVc2VyMSIsImV4cGlyZUF0IjoxNTQ0ODAzMjAwLCJwZXJtaXNzaW9uIjoidXNlciJ9";
        System.out.println(token1.equals(token1Test));
    }
}
