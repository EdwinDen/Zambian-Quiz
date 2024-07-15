import javax.swing.*;
import java.util.HashMap;

public class Questions{
    static String[] question = new String[]{
        "1.What is the capital city of Zambia?",
        "2.What is the official language of Zambia?",
        "3.Which river is the longest in Zambia?",
        "4.What is the currency of Zambia?",
        "5.In which year did Zambia gain independence from Britain?",
        "6.Which is the largest city in Zambia?",
        "7.Which national park in Zambia is known for its walking safaris?",
        "8.What is the main export of Zambia?",
        "9.Which waterfall is located on the border between Zambia and Zimbabwe?",
        "10.Who was the first president of Zambia?",
        "11.Which is the largest province in Zambia by area?",
        "12.What is the traditional Zambian dish made from maize flour?",
        "13.Which lake forms part of Zambia's northern border?",
        "14.How many provinces are there in Zambia?",
        "15.Which is the main legislative body of Zambia?",
        "16.Which Zambian city is known as the \"Copper Capital\"?",
        "17.What is the highest point in Zambia?",
        "18.Which body of water is shared by Zambia and Zimbabwe?",
        "19.What is the name of the Zambian National Football Team?",
        "20.Which festival is celebrated by the Lozi people in Zambia?",
        "21.Which city is home to the University of Zambia",
        "22.What is the main religion in Zambia?",
        "23.Which is the oldest game park in Zambia?",
        "24.What is Zambia's motto?",
        "25.Who is the current president of Zambia (as of 2024)?",
        "26.Which animal is featured on the Zambian coat of arms?",
        "27.What is the name of Zambia’s legislative capital?",
        "28.Which river is a major tributary of the Zambezi in Zambia?",
        "29.Which city is known as the tourist capital of Zambia?",
        "30.Which traditional ceremony is celebrated by the Ngoni people in Zambia?",
        "31.What is the primary industry in the Copperbelt region of Zambia?",
        "32.Which Zambian airport is the largest?",
        "33.What is the name of the national airline of Zambia?",
        "34.Which city in Zambia is known for its copper mining activities?",
        "35.What is the predominant climate in Zambia?",
        "36.Which is the main port of entry for tourists visiting Victoria Falls?",
        "37.What is the name of the traditional Zambian attire for women?",
        "38.Which Zambian province is known for its tobacco far tobacco farming",
        "39.Which river forms the border between Zambia and Zimbabwe?",
        "40.Who is Zambia's first female vice president?",
        "41.Which city is home to the Copperbelt University?",
        "42.What is the name of the traditional Zambian drum used in ceremonies?",
        "43.Which is the largest man-made lake in Zambia?",
        "44.Which organization regulates Zambia's mining industry?",
        "45.Which Zambian city is known for its cement production?",
        "46.Which traditional dance is performed by the Bemba people in Zambia?",
        "47.What is the primary source of electricity in Zambia?",
        "48.Which is the highest court in Zambia?",
        "49.Which city is known as the gateway to the Northern Circuit tourist attractions in Zambia?",
        "50.Which river is associated with the Barotse Floodplain in Zambia?",
        "51.Which is the most popular sport in Zambia?",
        "52.Which Zambian province is known for its tourism and wildlife?",
        "53.Which ethnic group is the largest in Zambia?",
        "54.Which Zambian city hosts the annual Zambia Agricultural and Commercial Show?",
        "55.What is the name of the Zambian national anthem?",
        "56.Which is the main export destination for Zambian copper?",
        "57.Which Zambian city is known for its sugar production?",
        "58.Which river is a major tributary of the Kafue River in Zambia?",
        "59.Which is the largest ethnic group in Zambia’s Eastern Province?",
        "60.Which Zambian city is famous for its annual Mutomboko ceremony?",
        "61.Which Zambian city is the commercial and industrial hub of the country?",
        "62.Which Zambian national park is a UNESCO World Heritage Site?",
        "63.Which river forms part of the border between Zambia and Namibia?",
        "64.Which city in Zambia is known for its textile industry?",
        "65.What is the traditional Zambian fishing method using reeds and grass?",
        "66.Which is the main staple food of Zambia?",
        "67.Which Zambian province is known for its gemstones, particularly emeralds?*",
        "68.Which traditional ceremony is celebrated by the Bemba people in Zambia?",
        "69.Which is the main livestock reared in Zambia?",
        "70.Which is the main Zambian celebration of independence?",
        "71.Which Zambian province is known for its maize production?",
        "72.Which is the main fruit grown in Zambia’s Eastern Province?",
        "73.Which is the largest hydroelectric dam in Zambia?",
        "74.Which Zambian province is known for its traditional crafts and pottery?",
        "75.Which is the main road linking Zambia to Tanzania?",
        "76.Which traditional Zambian instrument is similar to a xylophone?",
        "77.Which Zambian city is known for its annual beer festival?",
        "78.Which Zambian province is known for its coffee production?",
        "79.Which is the main Zambian cultural festival celebrating unity?",
        "80.Which Zambian city is known for its annual agriculture show?",
        "81.Which is the main export crop of Zambia?",
        "82.Which Zambian province is known for its traditional fish farming?",
        "83.Which Zambian city is known for its traditional dance festival?",
        "84.Which is the main economic activity in Zambia’s Northern Province?",
        "85.Which Zambian river is famous for its tiger fishing?",
        "86.Which traditional ceremony is celebrated by the Lozi people in Zambia?",
        "87.Which is the main food crop grown in Zambia’s Southern Province?",
        "88.Which Zambian city is known for its traditional pottery industry?",
        "89.Which is the main cash crop grown in Zambia’s Eastern Province?",
        "90.Which Zambian river is famous for its canoeing and rafting activities?",
        "91.Which Zambian city is known for its traditional wood carving industry?",
        "92.Which is the main export destination for Zambian tobacco?",
        "93.Which Zambian province is known for its traditional basket weaving?",
        "94.Which traditional ceremony is celebrated by the Lunda people in Zambia?",
        "95.Which Zambian city is known for its traditional bead making industry?",
        "96.Which is the main export destination for Zambian cotton?",
        "97.Which Zambian province is known for its traditional canoe making?",
        "98.Which traditional ceremony is celebrated by the Tonga people in Zambia?",
        "99.Which Zambian city is known for its traditional mask making industry?",
        "100.Which is the main export destination for Zambian maize?",
    };

   static String[][] options = new String[][]{
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Swahili","French","English","Portuguese"},
            {"Zambezi River","Kafue River","Luangwa River","Chambeshi River"},
            {"Kwacha","Rand","Shilling","Dollar"},
            {"1950","1964","1975","1980"},
            {"Lusaka","Kitwe","Ndola","Livingstone"},
            {"Kafue National park","South Luangwa National Park","Lower Zambezi National Park","Mosi-oa-Tunya National Park"},
            {"Coffee","Gold","Copper","Diamonds"},
            {"Angel Falls","Niagara Falls","Victoria Falls","Iguazu Falls"},
            {"Frederick Chiluba","Kenneth Kaunda","Levy Mwanawasa","Micheal Sata"},
            {"Lusaka Province","Copperbelt Province","North-Western Province","Western Province"},
            {"Ugali","Sadza","Nshima","Fufu"},
            {"Lake Victoria","Lake Tanganyika","Lake Malawi","Lake Turkana"},
            {"8","10","11","15"},
            {"National Assembly","Senate","House of Representatives","Parliament"},
            {"Lusaka","Ndola","Kitwe","Chingola"},
            {"Mount Kilimanjaro","Mafinga Central","Mount Meru","Mulanje Massif"},
            {"Lake Kariba","Lake Tanganyika","Lake Victoria","Lake Malawi"},
            {"Chipolopolo","Black Stars","Indomitable Lions","Pharaohs"},
            {"N'cwala","Kuomboka","Mutomboko","Umuganura"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Islam","Hinduism","Christianity","Buddhism"},
            {"Kafue National Park","South Luangwa National Park","North Luangwa National Park","Mosi-oa-Tunya National Park"},
            {"Unity and Freedom","One Zambia, One Nation","Peace and Progress","Strength in Diversity"},
            {"Edgar Lungu","Micheal Sata","Hakainde Hichilema","Rupiah Banda"},
            {"Elephant","Lion","Eagle","Buffalo"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Kafue River","Orange River","Limpopo","Volta River"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"N'cwala","Kuomboka","Mutomboko","Umuganura"},
            {"Agriculture","Mining","Tourism","Manufacturing"},
            {"Kenneth Kaunda International Airport","Simon Mwansa Kapwepwe International Airport","Harry Mwanga Nkumbula International","Mfuwe Airport"},
            {"Air Zambia","Zambezi Airlines","Proflight Zambia","Zambia Airways"},
            {"Lusaka","Ndola","Kitwe","Chingola"},
            {"Tropical","Desert","Mediterranean","Arctic"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Kanga","Chitenge","Dashiki","Sari"},
            {"Lusaka Province","Central Province","Eastern Province","Southern Province"},
            {"Kafue River","Zambezi River","Luangwa River","Chambeshi River"},
            {"Inonge Wina","Edith Nawakwi","Margaret Mwanakatwe","Dora Siliya"},
            {"Lusaka","Ndola","Kitwe","Chingola"},
            {"Ngoma","Djembe","Bongo","Conga"},
            {"Lake Tanganyika","Lake Kariba","Lake Malawi","Lake Victoria"},
            {"Zambia Chamber of Mines","Ministry of Mines and Minerals Development","Zambia Environmental Management Agency","Zesco"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Makishi","Kalela","Ingoma","Malipenga"},
            {"Coal","Hydro Power","Solar Power","Nuclear Power"},
            {"High Court","Constitutional Court","Supreme Court","Court of Appeal"},
            {"Lusaka","Ndola","Kitwe","Kasama"},
            {"Zambezi River","Kafue River","Luangwa River","Chambeshi River"},
            {"Rugby","Cricket","Football","Basketball"},
            {"Lusaka Province","Western Province","Southern Province","Eastern Province"},
            {"Bemba","Tonga","Lozi","Ngoni"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Nkosi Sikelel'iAfrika","Stand and Sing of Zambia, Proud and Free","God Bless Zambia","Arise, O Compatriots"},
            {"China","USA","India","South Africa"},
            {"Lusaka","Ndola","Mazabuka","Kitwe"},
            {"Luangwa River","Lufupa River","Lunga River","Chambeshi River"},
            {"Ngoni","Lozi","Bemba","Tonga"},
            {"Lusaka","Ndola","Mansa","Livingstone"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Kafue National Park","South Luangwa National Park","Mosi-oa-Tunya National Park","Lower Zambezi National Park"},
            {"Zambezi River","Okavango Riveer","Limpopo River","Kunene River"},
            {"Lusaka","Ndola","Livingstone","Kabwe"},
            {"Trawl fishing","Gillnetting","Bundu fishing","Basket fishing"},
            {"Maize","Rice","Wheat","Cassava"},
            {"Lusaka Province","Copperbelt Province","Central Province","North-Western Province"},
            {"N'cwala","Kuomboka","Mutomboko","Chibwelamushi"},
            {"Cattle","Sheep","Goats","Pigs"},
            {"Heroes Day","Unity Day","Independence Day","Africa Freedom Day"},
            {"Lusaka Province","Copperbelt Province","Central Province","North-Western Province"},
            {"Mango","Banana","Pineapple","Orange"},
            {"Kafue Gorger Dam","Kariba Dam","Itezhi-tezhi Dam","Victoria Falls Dam"},
            {"Lusaka Province","Western Province","Southern Province","Nothern Province"},
            {"Great East Road","Great North Road","Great West Road","Great South Road"},
            {"Mbira","Kalimba","Marimba","Balafon"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Lusaka Province","Copperbelt Province","Northern Province","Eastern Province"},
            {"N'cwala","Kuomboka","Mutomboko","Umuganura"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Maize","Tobacco","Cotton","Sugarcane"},
            {"Lusaka Province","Western Province","Southern Province","Northern Province"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Agriculture","Mining","Tourism","Manufacturing"},
            {"Zambezi River","Kafue River","Luangwa River","Chambeshi River"},
            {"N'cwala","Kuomboka","Mutomoboko","Umuganura"},
            {"Maize","Rice","Wheat","Cassava"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"Maize","Tobacco","Cotton","Sugarcane"},
            {"Zambezi River","Kafue River","Luangwa River","Chambeshi River"},
            {"Lusaka","Ndola","Kitwe","Livingdtone"},
            {"China","USA","India","South Africa"},
            {"Lusaka","Western Province","Southern Province","Northern Province"},
            {"N'cwala","Kuomboka","Mutomboko","Umuganura"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"China","USA","India","South Africa"},
            {"Lusaka Province","Western Province","Southern Province","Northern Province"},
            {"N'cwala","Kuomboka","Mutomboko","Umuganura"},
            {"Lusaka","Ndola","Kitwe","Livingstone"},
            {"China","USA","India","South Africa"},
    };

    public static void main(String[] args) {

//    Multiple choice options
        JRadioButton A = new JRadioButton("Option 1");
        JRadioButton B = new JRadioButton("Option 2");
        JRadioButton C = new JRadioButton("Option 3");
        JRadioButton D = new JRadioButton("Option 4");

        HashMap<String, JRadioButton> questionAnswer = new HashMap<>();

        questionAnswer.put(question[0], A);
        questionAnswer.put(question[1], C);
        questionAnswer.put(question[2], A);
        questionAnswer.put(question[3], A);
        questionAnswer.put(question[4], B);
        questionAnswer.put(question[5], A);
        questionAnswer.put(question[6], B);
        questionAnswer.put(question[7], C);
        questionAnswer.put(question[8], C);
        questionAnswer.put(question[9], A);
        questionAnswer.put(question[10], D);
        questionAnswer.put(question[11], C);
        questionAnswer.put(question[12], B);
        questionAnswer.put(question[13], B);
        questionAnswer.put(question[14], A);
        questionAnswer.put(question[15], C);
        questionAnswer.put(question[16], B);
        questionAnswer.put(question[17], A);
        questionAnswer.put(question[18], A);
        questionAnswer.put(question[19], B);
        questionAnswer.put(question[20], A);
        questionAnswer.put(question[21], C);
        questionAnswer.put(question[22], A);
        questionAnswer.put(question[23], B);
        questionAnswer.put(question[24], C);
        questionAnswer.put(question[25], C);
        questionAnswer.put(question[26], A);
        questionAnswer.put(question[27], A);
        questionAnswer.put(question[28], D);
        questionAnswer.put(question[29], A);
        questionAnswer.put(question[30], B);
        questionAnswer.put(question[31], A);
        questionAnswer.put(question[32], D);
        questionAnswer.put(question[33], D);
        questionAnswer.put(question[34], A);
        questionAnswer.put(question[35], D);
        questionAnswer.put(question[36], B);
        questionAnswer.put(question[37], C);
        questionAnswer.put(question[38], B);
        questionAnswer.put(question[39], A);
        questionAnswer.put(question[40], C);
        questionAnswer.put(question[41], A);
        questionAnswer.put(question[42], B);
        questionAnswer.put(question[43], B);
        questionAnswer.put(question[44], B);
        questionAnswer.put(question[45], B);
        questionAnswer.put(question[46], B);
        questionAnswer.put(question[47], C);
        questionAnswer.put(question[48], D);
        questionAnswer.put(question[49], A);
        questionAnswer.put(question[50], C);
        questionAnswer.put(question[51], C);
        questionAnswer.put(question[52], A);
        questionAnswer.put(question[53], A);
        questionAnswer.put(question[54], B);
        questionAnswer.put(question[55], A);
        questionAnswer.put(question[56], C);
        questionAnswer.put(question[57], B);
        questionAnswer.put(question[58], A);
        questionAnswer.put(question[59], C);
        questionAnswer.put(question[60], A);
        questionAnswer.put(question[61], C);
        questionAnswer.put(question[62], A);
        questionAnswer.put(question[63], D);
        questionAnswer.put(question[64], D);
        questionAnswer.put(question[65], A);
        questionAnswer.put(question[66], B);
        questionAnswer.put(question[67], D);
        questionAnswer.put(question[68], A);
        questionAnswer.put(question[69], C);
        questionAnswer.put(question[70], C);
        questionAnswer.put(question[71], A);
        questionAnswer.put(question[72], B);
        questionAnswer.put(question[73], B);
        questionAnswer.put(question[74], B);
        questionAnswer.put(question[75], C);
        questionAnswer.put(question[76], A);
        questionAnswer.put(question[77], C);
        questionAnswer.put(question[78], A);
        questionAnswer.put(question[79], A);
        questionAnswer.put(question[80], B);
        questionAnswer.put(question[81], B);
        questionAnswer.put(question[82], A);
        questionAnswer.put(question[83], A);
        questionAnswer.put(question[84], A);
        questionAnswer.put(question[85], B);
        questionAnswer.put(question[86], A);
        questionAnswer.put(question[87], D);
        questionAnswer.put(question[88], B);
        questionAnswer.put(question[89], A);
        questionAnswer.put(question[90], D);
        questionAnswer.put(question[91], B);
        questionAnswer.put(question[92], B);
        questionAnswer.put(question[93], C);
        questionAnswer.put(question[94], D);
        questionAnswer.put(question[95], C);
        questionAnswer.put(question[96], B);
        questionAnswer.put(question[97], A);
        questionAnswer.put(question[98], D);
        questionAnswer.put(question[99], D);

    }
}