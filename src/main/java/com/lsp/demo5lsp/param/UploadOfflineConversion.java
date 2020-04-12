package com.lsp.demo5lsp.param;

import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v1.errors.GoogleAdsError;
import com.google.ads.googleads.v1.errors.GoogleAdsException;
import com.google.ads.googleads.v1.services.ClickConversion;
import com.google.ads.googleads.v1.services.ClickConversionResult;
import com.google.ads.googleads.v1.services.ConversionUploadServiceClient;
import com.google.ads.googleads.v1.services.UploadClickConversionsResponse;
import com.google.ads.googleads.v1.utils.ResourceNames;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.StringValue;

import java.io.IOException;

/**
 * @author lsp
 * @description TODO
 * @date 2020/4/3 18:17
 **/
public class UploadOfflineConversion  {

    private static class UploadOfflineConversionParams {

        private Long customerId;

        private Long conversionActionId;

        private String gclid;

        private String conversionDateTime;

        private Double conversionValue;
    }

    public static void main(String[] args){
        UploadOfflineConversionParams params = new UploadOfflineConversionParams();
        Boolean checkParams = true;
        if (checkParams) {
            params.customerId = Long.parseLong("1");
            params.conversionActionId = Long.parseLong("1");
            params.gclid = "gclid";
            params.conversionDateTime = "2010-04-07";
            params.conversionValue = Double.parseDouble("conversionValue");
        }
        GoogleAdsClient googleAdsClient = null;
        try{
            googleAdsClient = GoogleAdsClient.newBuilder().fromPropertiesFile().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new UploadOfflineConversion().run(
                    googleAdsClient,
                    params.customerId,
                    params.conversionActionId,
                    params.gclid,
                    params.conversionDateTime,
                    params.conversionValue
            );
        } catch (GoogleAdsException gae){
            System.out.println("Request ID %s failed due to GoogleAdsException.Underlying errors:%n "+gae.getRequestId());
            int i = 0;
            for (GoogleAdsError googleError : gae.getGoogleAdsFailure().getErrorsList()) {
                System.out.println("Error %d:%s%n"+i++ + googleError);
            }
        }



    }

    private void run(GoogleAdsClient googleAdsClient, Long customerId, Long conversionActionId, String gclid, String conversionDateTime, Double conversionValue ){
        // get the conversion action resource name
        String conversionActionResourceName = ResourceNames.conversionAction(customerId,conversionActionId);
        // creates the click conversion
        ClickConversion clickConversion = ClickConversion.newBuilder()
                .setConversionAction(StringValue.of(conversionActionResourceName))
                .setConversionDateTime(StringValue.of(conversionDateTime))
                .setConversionValue(DoubleValue.of(conversionValue))
                .setCurrencyCode(StringValue.of("CNY"))
                .setGclid(StringValue.of(gclid))
                .build();
        // creates the conversion upload service client
        try(ConversionUploadServiceClient conversionUploadServiceClient =
                    googleAdsClient.getLatestVersion().createConversionUploadServiceClient()){
            // uploads the click conversion
            UploadClickConversionsResponse response = conversionUploadServiceClient
                    .uploadClickConversions(
                            Long.toString(customerId),
                            ImmutableList.of(clickConversion),
                            // Enables partial failure (must be true)
                            true,
                            // Disables validate only
                            false);
            // prints any partial errors returned
            if (response.hasPartialFailureError()) {
                System.out.println("Partial error encountered %s.%n"+response.getPartialFailureError().getMessage());
            }
            // Prints the result
            ClickConversionResult result = response.getResults(0);
            // only print valid result
            if (result.hasGclid()) {
                System.out.println("result :"+
                        result.getConversionDateTime().getValue()+
                        result.getGclid().getValue()+
                        result.getConversionAction().getValue());
            }
        }

    }


}
