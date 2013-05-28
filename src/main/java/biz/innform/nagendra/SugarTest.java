package biz.innform.nagendra;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/12/12
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class SugarTest {
    private static HttpClient client = new HttpClient();
    private static HttpMethod method = new PostMethod("http://www.crm.orangecounty.in/service/v4_1/rest.php");
    //private static HttpMethod method = new PostMethod("http://www.innform.biz/Sugar/service/v4_1/rest.php");
    private static String[] CONTACT_FIELDS;
    private static final String MODULE_CONTACTS = "Contacts";
    private static final String MODULE_OPPORTUNITIES = "Opportunities";
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        NameValuePair[] nameValuePairs = new NameValuePair[]{
                new NameValuePair("method", "login"),
                new NameValuePair("input_type", "JSON"),
                new NameValuePair("response_type", "JSON"),
                new NameValuePair("rest_data", "{\"user_auth\":{\"user_name\":\"admin\",\"password\":\"0ef87f16bf91a6a7a2bda3cf17dd5be7\"},\"application\":\"crs\",\"name_value_list\":[]}")
        };
        method.setQueryString(nameValuePairs);
        int statusCode = 0;
        try {
            statusCode = client.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error");
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            SugarResponse sugarResponse = mapper.readValue(method.getResponseBodyAsString(), SugarResponse.class);
            String sessionId = sugarResponse.getId();
            System.out.println("SessionId : " + sugarResponse.getId());

            if (sessionId != null) {
                //getContactById(sessionId, "9a32008d-8bb8-e8f9-f1c5-4f7a9e2c6661");
                getContactByEmail(sessionId, "maurya.shekar@orangecounty.in");
                //getUserByCrsUname(sessionId, "test");
                //createOrModifyContact(sessionId);
                //createOpportunity(sessionId);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getContactById(String sessionId, String contactId) {
        ObjectMapper mapper = new ObjectMapper();
        Class c = SugarContactFields.class;
        CONTACT_FIELDS = new String[c.getDeclaredFields().length];
        int i = 0;
        for (Field field : c.getDeclaredFields()) {
            CONTACT_FIELDS[i++] = field.getName();
        }

        String contactFieldsJson = "";
        try {
            contactFieldsJson = mapper.writeValueAsString(CONTACT_FIELDS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        NameValuePair[] nameValuePairs = new NameValuePair[]{
                new NameValuePair("method", "get_entry"),
                new NameValuePair("input_type", "JSON"),
                new NameValuePair("response_type", "JSON"),
                new NameValuePair("rest_data", "{\"session\":\"" + sessionId + "\",\"module_name\":\"" + MODULE_CONTACTS + "\",\"id\":\"" + contactId + "\",\"select_fields\":" + contactFieldsJson + ",\"link_name_to_fields_array\":[],\"track_view\":\"true\"}")};

        method.setQueryString(nameValuePairs);
        int statusCode = 0;
        try {
            statusCode = client.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error");
        }
        String result = "";
        try {
            CustomerProfile customer = new CustomerProfile();
            Address address = new Address();

            result = method.getResponseBodyAsString();
            EntryResult entryResult = mapper.readValue(method.getResponseBodyAsString(), EntryResult.class);

            if (entryResult != null) {
                for (EntryValue entryValue : entryResult.getEntry_list()) {
                    SugarContactFields contact = entryValue.getName_value_list();
                    customer.setTitle(contact.getSalutation().getValue());
                    customer.setFirstName(contact.getFirst_name().getValue());
                    customer.setLastName(contact.getLast_name().getValue());
                    customer.setCrmAccountName(contact.getAccount_name().getValue());
                    customer.setCrmAccountId(contact.getAccount_id().getValue());
                    customer.setCrmContactId(contact.getId().getValue());
                    customer.setMobile(contact.getPhone_mobile().getValue());
                    customer.setTelephone(contact.getPhone_work().getValue());
                    customer.setEmail(contact.getEmail1().getValue());

                    address.setAddress(contact.getPrimary_address_street().getValue());
                    address.setCity(contact.getPrimary_address_city().getValue());
                    address.setProvince(contact.getPrimary_address_state().getValue());
                    address.setCountry(contact.getPrimary_address_country().getValue());
                    address.setPostalCode(contact.getPrimary_address_postalcode().getValue());

                    customer.setAddress(address);
                }
            }

            System.out.println("Get_Entry result " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getContactByEmail(String sessionId, String email) {
        ObjectMapper mapper = new ObjectMapper();
        Class c = SugarContactFields.class;
        CONTACT_FIELDS = new String[c.getDeclaredFields().length];
        int i = 0;
        for (Field field : c.getDeclaredFields()) {
            CONTACT_FIELDS[i++] = field.getName();
        }

        String contactFieldsJson = "";
        try {
            contactFieldsJson = mapper.writeValueAsString(CONTACT_FIELDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        NameValuePair[] nameValuePairs = new NameValuePair[]{
                new NameValuePair("method", "get_entry_list"),
                new NameValuePair("input_type", "JSON"),
                new NameValuePair("response_type", "JSON"),
                new NameValuePair("rest_data", "{\"session\":\"" + sessionId + "\",\"module_name\":\"" + MODULE_OPPORTUNITIES + "\",\"query\":\"opportunities.name='test'\",\"order_by\":\"\",\"offset\":\"0\",\"select_fields\":[],\"link_name_to_fields_array\":[],\"max_results\":\"1\",\"deleted\":\"true\"}")};


        method.setQueryString(nameValuePairs);
        int statusCode = 0;
        try {
            statusCode = client.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error");
        }
        String result = "";
        try {
            CustomerProfile customer = new CustomerProfile();
            Address address = new Address();

            result = method.getResponseBodyAsString();

//            EntryResult entryResult = mapper.readValue(method.getResponseBodyAsString(), EntryResult.class);
//            if (entryResult != null) {
//                for (EntryValue entryValue : entryResult.getEntry_list()) {
//                    SugarContactFields contact = entryValue.getName_value_list();
//                    customer.setTitle(contact.getSalutation().getValue());
//                    customer.setFirstName(contact.getFirst_name().getValue());
//                    customer.setLastName(contact.getLast_name().getValue());
//                    customer.setCrmAccountName(contact.getAccount_name().getValue());
//                    customer.setCrmAccountId(contact.getAccount_id().getValue());
//                    customer.setCrmContactId(contact.getId().getValue());
//                    customer.setMobile(contact.getPhone_mobile().getValue());
//                    customer.setTelephone(contact.getPhone_work().getValue());
//                    customer.setEmail(contact.getEmail1().getValue());
//
//                    address.setAddress(contact.getPrimary_address_street().getValue());
//                    address.setCity(contact.getPrimary_address_city().getValue());
//                    address.setProvince(contact.getPrimary_address_state().getValue());
//                    address.setCountry(contact.getPrimary_address_country().getValue());
//                    address.setPostalCode(contact.getPrimary_address_postalcode().getValue());
//
//                    customer.setAddress(address);
//                }
//            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createOrModifyContact(String sessionId) {
        NameValue[] contactFieldArray = new NameValue[14];
        contactFieldArray[0] = new NameValue("first_name", "Maurya");
        contactFieldArray[1] = new NameValue("last_name", "shekar");
        contactFieldArray[2] = new NameValue("email1", "maurya.shekar@orangecounty.in");
        contactFieldArray[3] = new NameValue("primary_address_street", "21 Museum road,St. Patric Business Complex,2nd Floor");
        contactFieldArray[4] = new NameValue("primary_address_city", "Banglore");
        contactFieldArray[5] = new NameValue("primary_address_state", "Karnataka");
        contactFieldArray[6] = new NameValue("primary_address_postalcode", "56000");
        contactFieldArray[7] = new NameValue("primary_address_country", "India");
        contactFieldArray[8] = new NameValue("phone_work", "08041191081");
        contactFieldArray[9] = new NameValue("phone_mobile", "9535068989");
        contactFieldArray[10] = new NameValue("salutation", "Mr");
        contactFieldArray[11] = new NameValue("assigned_user_name", "admin");
        contactFieldArray[12] = new NameValue("assigned_user_id", "1");
        contactFieldArray[13] = new NameValue("id", "eae2d554-bbbc-dab6-f397-4f8820cd244b");


        ObjectMapper mapper = new ObjectMapper();
        String contactJson = "";
        try {
            contactJson = mapper.writeValueAsString(contactFieldArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!contactJson.isEmpty()) {
            NameValuePair[] nameValuePairs = new NameValuePair[]{
                    new NameValuePair("method", "set_entry"),
                    new NameValuePair("input_type", "JSON"),
                    new NameValuePair("response_type", "JSON"),
                    new NameValuePair("rest_data", "{\"session\":\"" + sessionId + "\",\"module_name\":\"" + MODULE_CONTACTS + "\",\"name_value_list\":" + contactJson + ",\"track_view\":\"false\"}")
            };
            method.setQueryString(nameValuePairs);
            int statusCode = 0;
            try {
                statusCode = client.executeMethod(method);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Error");
            }
            try {
                System.out.println("Set_Entry result " + method.getResponseBodyAsString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createOpportunity(String sessionId) {
        NameValue[] opportunityFieldArray = new NameValue[8];
        opportunityFieldArray[0] = new NameValue("name", "test");
        opportunityFieldArray[1] = new NameValue("sales_stage", "test");
        opportunityFieldArray[2] = new NameValue("amount", "1000");
        opportunityFieldArray[3] = new NameValue("opportunity_type", "test");
        opportunityFieldArray[4] = new NameValue("account_name", "FIT");
        opportunityFieldArray[5] = new NameValue("date_closed", sdf.format(Calendar.getInstance().getTime()));
        opportunityFieldArray[6] = new NameValue("assigned_user_name", "admin");
        opportunityFieldArray[7] = new NameValue("assigned_user_id", "9a32008d-8bb8-e8f9-f1c5-4f7a9e2c6661");
        ObjectMapper mapper = new ObjectMapper();
        String opportunityJson = "";
        String opportunityId = "";
        try {
            opportunityJson = mapper.writeValueAsString(opportunityFieldArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!opportunityJson.isEmpty()) {
            NameValuePair[] nameValuePairs = new NameValuePair[]{
                    new NameValuePair("method", "set_entry"),
                    new NameValuePair("input_type", "JSON"),
                    new NameValuePair("response_type", "JSON"),
                    new NameValuePair("rest_data", "{\"session\":\"" + sessionId + "\",\"module_name\":\"" + MODULE_OPPORTUNITIES + "\",\"name_value_list\":" + opportunityJson + ",\"track_view\":\"false\"}")
            };
            method.setQueryString(nameValuePairs);
            System.out.println(method.getQueryString());
            int statusCode = 0;
            try {
                statusCode = client.executeMethod(method);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Error");
            }
            try {
                System.out.println("Set_Entry result " + method.getResponseBodyAsString());
                SugarResponse sugarResponse = mapper.readValue(method.getResponseBodyAsString(), SugarResponse.class);
                opportunityId = sugarResponse.getId();
                System.out.println("OpportunityId : " + sugarResponse.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!opportunityId.isEmpty()) {
                try {
                    opportunityJson = mapper.writeValueAsString(new String[]{opportunityId});
                } catch (IOException e) {
                    e.printStackTrace();
                }
                nameValuePairs = new NameValuePair[]{
                        new NameValuePair("method", "set_relationship"),
                        new NameValuePair("input_type", "JSON"),
                        new NameValuePair("response_type", "JSON"),
                        new NameValuePair("rest_data", "{\"session\":\"" + sessionId + "\",\"module_name\":\"" + MODULE_CONTACTS + "\",\"module_id\":\"9a32008d-8bb8-e8f9-f1c5-4f7a9e2c6661\",\"link_field_name\":\"opportunities\",\"related_ids\":" + opportunityJson + ",\"name_value_list\":[]}")
                };
                method.setQueryString(nameValuePairs);
                statusCode = 0;
                try {
                    statusCode = client.executeMethod(method);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (statusCode != HttpStatus.SC_OK) {
                    System.out.println("Opportunity not linked to contact");
                } else
                    try {
                        System.out.println(method.getResponseBodyAsString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

        }


    }

    public static void getUserByCrsUname(String sessionId, String uname) {
        ObjectMapper mapper = new ObjectMapper();
        NameValuePair[] nameValuePairs = new NameValuePair[]{
                new NameValuePair("method", "get_entry_list"),
                new NameValuePair("input_type", "JSON"),
                new NameValuePair("response_type", "JSON"),
                new NameValuePair("rest_data", "{\"session\":\"" + sessionId + "\",\"module_name\":\"Users\",\"query\":\"crs_user_name_c like '" + uname + "%'\",\"order_by\":\"\",\"offset\":\"0\",\"select_fields\":[],\"link_name_to_fields_array\":[],\"max_results\":\"10\",\"deleted\":\"false\"}")};

        method.setQueryString(nameValuePairs);
        int statusCode = 0;
        try {
            statusCode = client.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error");
        }
        String result = "";
        SugarUserFields fields = null;
        try {
            result = method.getResponseBodyAsString();
            UserEntryResult entryResult = mapper.readValue(method.getResponseBodyAsString(), UserEntryResult.class);
            for (UserEntryValue userEntryValue : entryResult.getEntry_list()) {
                fields = userEntryValue.getName_value_list();
            }
            System.out.println(result);
            System.out.println(fields);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
