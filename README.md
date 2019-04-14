# JobFinder
Android Project for Progress Soft Company 



**Summary :**
Android App for showing a jobs from there providers with filteration , adding a new providers is very easy! .



**Libraries :**
1) ButterKnife : 
   It's permit to me to bind the XML views with there connected fields in there classes ,
   depends on the Auto Generated code by implementing the Annotation proccess logic .
2) Javax :
   It's a utils annotaions , i used it to extract the POJO classes from a JSON responce .
3) GooglePlayServices :
   To interact with Google Apis , i used it to show the google autocomplete locations screen .
4) Retrofit : 
   To interact with the HTTP Restful Apis , it a powerful because it also as ButterKnife depends on 
   the Auto Generated code by implementing the Annotation proccess logic
5) Glide : 
   Handling the images downloading with a many utils embedded inside, The most important thing that this
   library also handles the Out Of Memory issues .
6) Mockito :
   A unit test library that use also the annotaion proccessing concept with ability to mock objects from the android sdk classes.
7) Robolectric :
   A unit test library that use also the annotaion proccessing concept with ability to shadow objects from the android sdk classes
   , another important thing is handling some Android Sdk classes over Mockito like *putExtra* which is not mocked by Mockito .
7) Junit :
   The Default unit test library from Android.

**Project Folders :**

1) base : 
   Contains all the base classes of the app .
2) callback :
   Contains all the listners (abstract classes or interfaces) of the app .
3) config :
   Contains all the configuration classes like MyAppGlideModule Configuration .
4) constants : 
   Contains all the constants values like RequestCodes & Tags
5) data : 
   Contains all the data classes like Models & Restful Apis
6) ui :
   Contains the view classes .
7) util :
   Contains the all things about Utilities .
   
**The concept in details :**<br />
 1) Important Classes <br />
     1 - ApiClient : Has the configuration of Retrofit Http Calls library .<br />
     2 - ApiProviderInterface : Has the all Calls Apis .<br />
     3 - ProviderApiRepository : Has the implementing for the all Providers Calls Apis .<br />
     4 - ProviderStrategies : Has the strategies of the list providers , enum orders & provdier utils .<br />
     
 2) When the Main activity appears :<br />
      1- Setup the requested dependencies .<br />
      2- Show all providers jobs through communication with ProviderStrategies Class that will do a for 
      loop on the predefined providers list there & execute show list method for every provider that will 
      call the provider Api from ProviderApiRepository class (I pass the Query Object as new instance witout any values inside it) <br />
      
 3) Click on job item :<br />
      1- The main activity pass OnItemClickListener interface to the JobsAdapter , so there a click listener of the item will call OnClick 
      Callback from OnItemClickListener ,the callback implemented in the main activity will navigate the user to the 
      JobDetailsActivity by StartActivity() method & passing the url by intent extras. <br />
      2- The JobDetailsActivity receives the url by intent & sends it to the WebView . <br />
      
 4) Multiple Filteration :<br />
      1- The Project supports multiple filteration . When you click in the filter icon in the MainActivity at the toolbar ,
      the MainActivity will communicate with FilterCustomViewAlertDialog Class to show the filteration dialog by sending 
      the OnFilterListener interface with onDone method callback.<br /> 
      2- The filteration dialog has 3 types : Filter by Provider , Filter by Position & Filter by location .
      Filter by Provider will communicate with ProviderStrategies Class to get the current provider list .
      Filter by position will permit for you to write in the edit text the requested position title .
      Filter by location will show a Google autocomplete locations screen to select your target location , onActivityResult will 
      be execute in the MainActivity with RequestCode AUTO_COMPLETE_REQUEST_CODE then the MainActivity will capture the Place Object
      & returns it to the dialog .<br /> 
      3- When the user click done then all the selected filteration values will pool in the Query Object & return to the MainActivity
      by executing the onDone method callback .After that the MainActivity will communicate with ProviderStrategies Class with sending 
      the Query Object to show the list , there'r a validations here . <br />
      
**How to add a new provider (Scalability) ? : It's very easy , only trace the predefined Providers (GithubProvider & SearchGovProvider) behavior in the ProviderStrategies Class !!!**

    1- Add a new Provider Class in the getProviderList() method inside the ProviderStrategies Class  with extending from BaseProvider class with the same details inside the predefined Providers (GithubProvider & SearchGovProvider).
    2- Add a new ApiInterface with its Method inside ApiProviderInterface & pass its class to ur provider by constructor.
    3- Add a new Implementation method for ApiInterface Call inside the ProviderApiRepository Class .
    4- Add a new name for ur provider in ProviderNames Class and & pass it to ur provider by constructor.
    5- Add a new ProviderType for ur provider in ProviderStrategies Class & pass it to ur provider by constructor.
    6- Add a new ViewHolder for ur provider with extending from BaseViewHolder  & pass its class to ur provider by constructor.
    7- Don't forget to create JobObject as (GitHubJob & SearchGovJob) with adding ProviderType to abstract getProviderType() method inside it.
