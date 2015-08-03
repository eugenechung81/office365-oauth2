# office365-oauth2
Connect through Office365 unified REST API through Azure AD authorization grant flow.  

1.  Setup Azure AD application.  Set single-sign on Replay URL.  Set permission for other applications.  
2.  Setup client properties.
3.  Run login servlet which will fetch to user agent for authorization code and then redirect to main application to fetch access code for subsequent API calls.  

## Client Properties
```
	private static final String TENANT_ID = "TODO";
	private static final String CLIENT_ID = "TODO";
	private static final String CLIENT_SECRET = "TODO";
	private static final String RESOURCE_ID = "https://TODO-my.sharepoint.com";
```

## Servlets
```
http://localhost:8080/office365-oauth2/LoginServlet
```
Redirects to:
```
http://localhost:8080/office365-oauth2/AppServlet?code=AAABAAAAiL9Kn2Z27UubvWFPbm0gLYvaMMYwjC56Eb-JChnHCtnyjPJ5CkRFYQ3hsKD01srDzgpdt0y0fSjAZoMgfY9bqsZtA-L-8JobqHE3KmssVUgFuXlX3XqK-AtE0_uAHzRUIsDCEcyhdh5OYVVqKswKrj30zgQwUld67RK4s_8up6oa7somCVOvDzryD-XItT359lD5S13nSg8VnTgcpNrpGKia759zVncHl6PtAT__lCPFOqdyyvQnSJ-X3m6pLWXaWgdb45-vzCqaxBWdWtiUHfe2eqSRby_67f83M-WFQSVvp1z4RoMTuNv5UVRBdtAVmSjwvgdg__0mmVa43RHNEzJYBJLBFSnsf-bA3u1KT5Mx-pSFUL1cb7xUXtq77OUa8PdGeJBV7EA86GaUC2gZofsPpJgW2S9mKaGyAZR2atRkDnv99cmh0KDtbHnbTDtkGBUALEHnYcr_WFtmJ8zZGeoEqUVKRGDcHfTbacyVAw7r7JaV8U8nAV--TdSsE6RliRFisE5OU8EHA5NPjkTotz1dto0u240y73Ds-LF4DcaGe1vsbSRr_DURfD8B0jQsXHv7VnQ822nH7QQfPoYeUiAA&session_state=c17706ec-6f99-4d8f-851b-bd485a245823
```
