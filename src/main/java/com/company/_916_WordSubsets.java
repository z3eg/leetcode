package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//https://leetcode.com/problems/word-subsets/
public class _916_WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        LinkedList<String> res = new LinkedList<>();
        int[] maxFreq = new int[26];
        for (String s2 : words2) {
            int[] freq = getFreq(s2);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i],freq[i]);
            }
        }
        for (String s1 : words1) {
            int[] s1Freq = getFreq(s1);
            if (isSubset(maxFreq,s1Freq))
                res.add(s1);
        }
        return res;
    }

    private int[] getFreq(String s) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c-97]++;
        }
        return freqs;
    }

    private boolean isSubset(int[] aFreq, int[] bFreq) {
        for (int i = 0; i < 26; i++) {
            if (aFreq[i] > bFreq[i])
                return false;
        }
        return true;
    }

    /*public String[] normalizeInput(String[] input) {
        TreeSet<String> stringTreeSet = new TreeSet<String>;
        stringTreeSet.addAll(Arrays.asList(input));
        LinkedList<String> result = new LinkedList<>();
        Iterator<String> iterator = stringTreeSet.iterator();
        while (iterator.hasNext()) {
            for (String s : result) {
                if (isSubset(iterator.next(), s))
            }
        }


        return result.toArray(new String[]{});
    }*/

    /*public List<String> wordSubsets(String[] words1, String[] words2) {
        LinkedList<String> res = new LinkedList<>();
        for (String s : words1) {
            if (isUniversal(s, words2)) {
                res.add(s);
            }
        }
        return res;
    }

    private boolean isUniversal(String a, String[] strings) {
        for (String s : strings) {
            if (!isSubset(s,a)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSubset(String a, String s) {
        List<Character> charList = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        for (char c : a.toCharArray()) {
            if (charList.contains(c)) {
                charList.remove(Character.valueOf(c));
            }
            else {
                return false;
            }
        }
        return true;
    }
*/

    /*private boolean isSubset(String a, String s) {
        List<Character> charList = a.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        List<Character> sList = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        return sList.containsAll(charList); //TODO doesn't work for some reason, can't even debug this
    }*/

    /*private boolean isUniversal(String a, String[] strings) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : a.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c,1);
            }
        }
        for (String s : strings) {
            if (!isSubset(new HashMap<>(map), s)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSubset(Map<Character,Integer> map, String s) {
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Integer value = map.get(c);
                if (value == 0) {
                    return false;
                }
                map.put(c, value -1);
            }
            else {
                return false;
            }
        }
        return true;
    }

    private boolean isSubset(String b, String a) {
        List<Character> charList = a.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        for (char c : b.toCharArray()) {
            if (charList.contains(c)) {
                charList.remove(Character.valueOf(c));
            }
            else {
                return false;
            }
        }
        return true;
    }

    private String[] filterWords(String[] words) {


        TreeSet<String> wordSet = new TreeSet<>();
        for (String word : words) {
            for (String wordInSet : wordSet) {
                *//*word.repl
                if (wordInSet)*//*
            }
        }
        *//*AtomicBoolean changed = new AtomicBoolean(true);

        while (changed.get()) {
            changed.set(false);
            wordSet.forEach(word -> wordSet.forEach(anotherWord -> {
                if (word.contains(anotherWord)) {
                    wordSet.remove(anotherWord);
                    changed.set(true);
                }
            }));
        }
        return wordSet.toArray(new String[]{});*//*
        return new String[]{};
    }
*/
    /*@Test
    public void testFilterWords() {
        assertArrayEquals(new String[]{"foo"}, filterWords(new String[]{"foo","o","oo"}));
        assertArrayEquals(new String[]{"foo"}, filterWords(new String[]{"foo","oo","o"}));
        assertArrayEquals(new String[]{"foo"}, filterWords(new String[]{"foo","fo","o"}));
        assertArrayEquals(new String[]{"foo"}, filterWords(new String[]{"foo","fo","f"}));
        assertArrayEquals(new String[]{"foo", "fo"}, filterWords(new String[]{"foo","fo"}));
    }*/

    /*@Test
    public void testIsUniversal() {
        assertTrue(isUniversal("leetcode",new String[]{"eo","lo"}));
        assertTrue(isUniversal("facebook",new String[]{"e","o"}));
        assertTrue(isUniversal("google",new String[]{"e","o"}));
        assertTrue(isUniversal("leetcode",new String[]{"e","o"}));
        assertTrue(isUniversal("apple",new String[]{"e","l"}));
        assertTrue(isUniversal("google",new String[]{"e","l"}));
        assertTrue(isUniversal("leetcode",new String[]{"e","l"}));
    }*/
    //too slow
    /*public List<String> wordSubsets(String[] words1, String[] words2) {
        LinkedList<String> res = new LinkedList<>();
        for (String value : words1) {
            boolean isUniversal = true;
            for (String s : words2) {
                if (!isSubset(s, value)) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal)
                res.add(value);
        }
        return res;
    }*/

    /*@Test
    public void testSubset() {
        assertTrue(isSubset("wrr","warrior"));
        assertFalse(isSubset("wrr","world"));
    }*/

    @Test
    public void testReplace() {
        String s = "boolean";
        s = s.replaceFirst("o", "");
        System.out.println(s);
    }

    @Test
    public void test() {
//        assertArrayEquals(new String[]{"facebook","google","leetcode"},
//                wordSubsets(new String[]{"tetfjjdaxl","jldmtsxoef","dwmtfjxnwh","ydczmfcxth","buxrujzghs","dytyqfyxyd","zfdtqfpdux","vgewkggjxm","sirvjtyuoc","ihgnfdtxxa","ydoluyihqm","iadoaexoft","cqeezcjfbu","nkhtycrbjq","txrxidbyfa","xtaahdxfva","efxdtwdaco","iyxtdnfhnh","ckttfkitry","dpxmfkmtxm","zxfdbmdjtz","ftuxdlvtft","xfwcttsdux","ispottwpjf","usthsdrxfm","qqpubilrfe","hfzctdxtgt","ngvymmkprt","vmcwixzvuo","tvnazdkziv","xjutndgkfq","odtpmujzsm","zrfitzxfjd","xfbtzudnil","xvfdhjptmb","kdhpwfyvnk","vtnphxdfum","axtdnfqrpg","mqooyoggca","bcxwftraxd","nddjffzxtb","vkboccrhap","bxffqldght","debtwcafxl","qxfnwztdms","zxwhmdtjof","jjpzmibuuh","ljddvzdfcc","pynhinzosl","xgnjcpdpiv","ftaxcdstfw","bpiiudnzps","txgitlsfad","xdtenqwftx","xntfgfdtfw","fmtdtxvhvd","ixjqfdwutk","nsmndxflot","ftbfudjeyx","frxldvefwt","mlmzwlvsgx","kfxpdntjfi","mzdejccess","umhqrmnpzr","dfbqfxntuk","pxfdffomlt","cwdtvxyvfl","tvixtzfrad","dtopdcuflt","fdwkbfunrd","fyszjowowo","epewykhlsx","kgbodrpqum","dtxclownxf","tjgshxeaag","cwodsxgftf","vtxfdkgxmh","pxdstdftlu","hmasfqddxt","xydxmgxxft","afwpxfdyvt","xlelgnucmn","djebetxvpf","xfdatfuybc","tbfxdxdhwy","przcdplspz","yxqdcftkml","dxtfzxzffg","xvapdrdjtf","xfftdxkhcd","zmqthfjxdt","ztrsfdkixn","fgrtgtdiqx","idukattjxf","atzflzddhx","afrdxpxvtn","cesyeajrgc","xfqagtwpyj","jsyfecxgmw","tfjnddafqx","narlrtzcji","lktupupumz","ktfobxdrac","rgpvzydopp","dfmetlmqxi","xrfhaydtsj","cgnhvcxtgf","fodpqfxhtd","ajyfxtdywa","dfugxhnxtv","fmpyxdqdit","pdxbytqpyf","vmbgpadvgj","gyccylnrrf","uccrduyfgl","xetqdexlef","oldjmmvzem","fdcxgbwjlt","aizqhdiyol","yspdzfomtx","qnfjlddtmc","daustyfwxl","vxitsdtouf","sxfohxtedz","uddcthfrxn","tjrjxzltat","dppxtdxzfx","xaobhgjaud","tyhkxdnwdf","jpsrpfpihy","okepgzwsnj","znlvhtpzxv","pyzdnlrfhb","fkxtatdzbf","iskptborcd","zrqmxnnopn","rkqrrloxnn","xvvtdafvfk","dbtdosdfmx","hpwvtxifdr","bywkabpemo","zfdxmqwtai","dwuftfuvdx","vdodtowftx","tzmdqcrcnw","pjmwaxxdtf","agyxvjrlki","wzeebetofm","kjutxfqdwa","ozdtlfnjcv","oxwprnunfx","ufxdiztkxc","lodafotzxm","jshltxjsdf","xwmbcpzoam","lkxgxztfjd","ytkiywfxvd","cxxfgatddg","wemsbwhuby","gfyhhougoi","gzvtdpyivg","bldxuxoetf","txrftdadwg","tkicjfxgtd","qenmnhafgv","yhwfmgaddj","kdsflxgttx","afxnbdqtqv","txmlbxxvfd","vjjqshbhcz","rjzpksallr","fyodftqxto","zhijddftxl","txfysdjryr","xgdfdlqcti","xttvypszhg","ltfiedxfxe","fdahtmkkxr","dzvfdtxrcp","dkzmixftds","irepfbkuxq","eydextdodf","noclmxgbhs","bxxdesfirt","xxjqdeftjf","kxsijotfds","yhlmmsyudj","qlxmotfmdo","anvpseqogb","lfxxfzihdt","zaevdomoto","uhthdbflxl","zayvtxctfd","dxdbxfejet","iqtumugzrg","xgdftgqewd","imxjanfdvt","fpdaqfwxmt","xtclfemrfd","dftmxxqhhn","dmftdxkkjv","txyshogziw","fgkfetxwdq","edkssssseo","ycrtfdzgqx","bfxdqoitga","bpbtxcfdwj","tixoqfdxak","fitbbxdyxx","fklxdtaosd","uodxfttfpq","qzkmnuxhuc","jtxdrfptwl","medxtckkfu","rzdhwhyerc","mtfdxtxrph","nraiavxejw","enehclhecc","xgdtocwfzy","fxxftdfmsk","iqfbpmxyas","kxhoxdfqtn","ietuhooesl","obtdpgxfzf","dfivfrwxte","sjsqhbvnxv","oytxfxxrdu","oaoonxhdjx","tyfrdnxbqe","tdxbvofnls","xooqftvdgt","vtpzxrffjd","nxdfhbtwtn","javpfkxdtd","xjftvlhdul","tydxgfetdi","bemnfkujjz","ymhggqrkzq","gdftsujxyf","slkhfhhvpo","ftuudxzpbx","fohwvcmebl","sexrrdlizy","tsdgyxovxf","xcftdxmdiz","ziydfcexjq","dfxotrpntt","sdzxdvdtfa","zxnzgfttes","cjrklfdfxt","gmtdcndxkf","hewthiawqg","ypxugfodty","mxuvhaziik","rorvqynkag","wxizdliftu","qpfatxdexs","vznacsetwv","ftuzxdlgpy","tdnxogcfkd","bfwktidjfx","ndlgkmfxft","ffesxdtiat","stqrqadjzw","hzayoshrep","njjsadncaf","itvzbanbho","qoknwoyqnp","tdfoylmabx","lttxfecftd","xdeafpzgdt","qdftkdaxta","sampluxqtw","ftdyvktxsl","tjxifdwsnv","fdsdvxuhrt","txzoidqwfj","krtifsgwjk","cffrcdxkkt","vfpxidexmt","fhythdyhmc","pjvzehhkjt","faotexaldr","vwtrgzxqyt","xgtyedlfhg","mtfdmdxtdx","vnrzowzfaa","dlnakzjqcz","dxawxatfqb","oyqxtodbvh","bdmtyxfdvs","jalcrzxbem","djwxtldfjn","vtgdfxmqdu","krzwbpzevs","xrpfttxdds","ulofzxdqto","toxtdfgjou","seltgwgtny","djhtkxxfrs","xfafnatedk","xngfdtxsmf","nywfitxdvc","dyaitxufky","eaxfltdtxx","xjxfnehwsl","bjfnxtotdg","fcpicbxhlb","xfpdtfxmmm","butulrfxdj","ynblctjcne","ktyidgdfpx","pwimrzefdc","zzbodxmqhk","jtfkgoqupy","ykdcmtoxqf","etrdxfdrwa","sojzsgdiza","uhfytkrxwd","plubnoxtfd","xnfdcmthfa","rffxwtcwdg","xsdaftftzw","efltcdyxfe","ebkarmfsen","ddtxuptbxf","dpddtmtxfg","xwvevahugv","jhstbwcpxy","yxfzmnjtud","fraqsiaspn","tctgrmxufx","trdhfvxtui","unimdqtiaf","otodyxghfu","fxxjcfgdtv","ujtapdsshc","bxlufclqzl","iitasxudsv","ptfaudqrxn","htopgfximd","isadtfevex","jykzyttztz","ctxvatxfed","ftptvlxudn","muxfdtfiae","txdvzuubfb","jtvvdmfxpe","dfftrgyfxq","jfdatmflxp","ugzsfjdyxt","mtfdytzdsx","qufnxicdot","txfdkowjpb","aijtwceyrp","uqdtdxfiyd","jxcgtifxdp","baidxlafot","lcjgxijjqr","jvqpdpsybh","htdeyhzobh","zxdtlbxyfh","xqtefyznfd","luhxtilofs","xzgwbylatt","lcctpfnpxc","ybaxgyzniw","stuudfyrxs","tfxxdsejnk","rdjjsrdnoj","ftddvxoxbl","bvxfxdtfdq","nxdeqtmqrf","fautvddfux","dupnitpfum","mtwtfgxdua","rsxetjfnfd","xmqutsfdzu","rguxdfrtvf","etnvaiqjcn","mxdzjtpfyk","dwxytnfbpn","xkfzxfivtd","wxfzftdedr","fxtkmjwdfh","qdtiswxfct","xlcdbxeftj","tvoomfdrvx","yxofddxptz","gtzyfzxkfd","ndtizrsfhx","fxddqwtwpw","utdfxjovab","zclytzdxjn","wxifjgwtds","gbiixsddzs","kemurlkrzx","tlndxfuwow","zujjlaqxcq","tqwdrxfqbu","srwhjzlgrx","xdnfiyrutp","kyxffcurdt","skcmiankub","fsfdttxfas","ykgdfgqxtq","gxpdctbftg","johgwrlhal","cxetdfuwqd","iwxildmtuf","ulmuiekddj","xtqssfddbl","mjxpugtdof","isjvafwqft","tidnhxefdu","ncpkdfxgtr","fkpjtdtuxe","kdynpqhrih","ttgntdxnfx","vanqdpsold","dmtzsnlxkf","tfkcduupxz","jybtezsnfg","pdwkxfyzyt","txpqdnfpkl","dwptdkzxnf","doxwftdfxr","nsduhywqay","qaaukbjwze","qktqbxdsxf","xtpdfdfxyw","wygqknkplw","yypjyxyrmh","upnidifxty","ylwovsufui","utrdxifagb","kuxfqtdhuc","hyguprhohx","ftdxaoozrt","qdvmfwxxta","wafbxgqtdn","manqkajqxk","oftitoxwds","bgtaxfdkit","zdxbitlqfu","nhyfcljbuu","padjqvxtix","wdvxtvrfkt","aftviukdxd","xfzxdvtmgf","scepcjaqso","tftdkreixd","pkwxrixyus","rhixftdruj","tdzuadxffr","ftedcdwxol","tdjrlyfwxy","kfoctdexto","uyvadtxdtf","nxdyteyrlf","adxszsktfz","ldtmxxcfbd","fybsnrptrm","urxjflltud","hodupyypcv","yqswfdubem","ijdnfxtiey","ddxfpuscgt","aetdtfdxet","rtewsxyjfd","detexfdclp","ddptxxfvtb","qdlmkfovhn","jfvnbfwxtd","sfptwrdxxs","rflzhodttx","yytfddvmxm","rtytfhpdxx","fijhoowxkv","dyxfcttnlh","agskdtvmbx","vadtofsvix","ffbsdlxvct","icnwmdxkmt","xxdfxzjtvz","xzowzhtmwi","giygxtdmfk","dwdzftbfxr","tfdnfxexmn","ynlcpqemzf","ekfglxdvti","wxcjikfxls","admtwoumxf","fxytadsdjf","jtxijavdfx","wcyfryyuop","jtxmduzvxf","fmytxtogsd","troqjjtlmj","yxdfxdtbnf","vtdxmbeffy","fgsxahtjjd","xftqdkzfoq","dtoraxofqk","pvjtgdpnfx","tbfndsydxt","tfqxesdihh","figidanixt","xdtiyyzyrf","wfsxaotdjm","pltzfduxsm","oqhoauurgp","moqwhdzksv","edtftykxzt","ofxncutmkd","kfhldtjyxh","zruxrdftra","jyxwlolqpq","qabxfrrtwd","xkbdtdifyf","xygpyqzura","nczuegxtan","xsnfllfdot","mxvhxwftqd","tykzldfxgm","fdyxtujfja","itfhlvfwui","hxpcnwegln","bnzzkzxwgd","otsfcvqfgz","yupspwsdfo","xtftrdhexa","wwmdjobxtf","owztndgdac","oxjrmzdkwl","dkjnxdfiyt","acxadffvpt","caboenwdgw","phdhbxfift","suvyagnvps","eshdxfydtr","gemogarckh","qjbheyifyf","zoftdsmofx","jikwsjdetv","ulgxahpptz","dfxamrxott","mrdhzickii","wfxdetvmwe","otmgblzyhf","xdifyswgtd","elttzetkcb","ygssqexhbw","oqnblxtwhc","yzbmsmiuxe","kftqdxfrxr","xdjfxjytbc","hphetxmfdu","rvfncqslqd","trfdnaxzdt","fuvadtqfxd","kfxxpcmdkt","yurxtdsufq","tdewcdxzrf","nurzyzusoh","hbfoznzjul","pfdpxjjtai","aeimsefhgn","iwglptnedo","lxwfdfamht","zhmrftnjes","doxfdsstly","xtwfdfxgqr","dwxdcndbft","vtfxffdwwg","nzcfpaftpq","aopyrraeyl","efdsxrtwdl","jcdtsrcofx","cztwtdboxf","edfwxjtfkk","gxtdsffevx","xafdthfcfi","sxtfuyndzy","cdqvfbxxqt","ztfdgssmxu","zfgzlfokxg","tojuufycxd","fdxjtmraxt","dhvtorpdfx","skkprgkvly","ubdexutgfn","ffacqqgdxt","dlxvftuoli","xydtefkxwc","bewnsmljpk","pasftxdjen","pxtuttdotf","wgcskeoxoq","dzhxsfibtb","fybdtrrxaj","fixtszydjn","ijuegzuqta","ftyiddxvqg","jwpikosjsh","vfxcdagtby","tyxxktrdmf","oztgyddkxf","gxrwkhprar","fekoitqkxd","grxzcfvtdl","iodoztfycx","lutyggbzhz","rgtdwxfyvo","gtriiqhpsb","kxvrdkfolt","xzyftfkdvd","efmpnuwtxd","fhztdognel","wxntrdfnef","xtyijgzfdb","edxvhpftmz","tqtjlxndvf","tzllcvtatx","cbcztcfddx","xjfqmdyuty","ddxfhvritz","ldexfxjfti","dxznutgzbg","txgidiaarf","lypdugitvh","yucozyrkus","zytxihabig","ogksklwmty","datkpjfxhy","tchdvwfxkd","gqsujhfgre","nyxxtbpcno","mtymfgqdrx","ythmvtflxd","spivtuwzhi","ddgufdxtax","lhlzryoizp","eaxabycxuf","dknqmtmfxs","yiqxdtwafh","pfxiqzsfiw","kfxdxtxufz","fdtgabxjpa","fdxniwiltv","hhdzzmqtxf","hobbxftdzz","fxoxbdftha","otxcdmiblf","riepdqfxbt","zltbfxiuvd","tfcvjdghxw","txkdffdqqq","muoojhxvcn","wefstxdlfy","wivcubhvgm","atxmdtrmxp","wventofubr","krpfsgxdlt","tvolgctoea","oyodxfxtct","nvnqgkywyi","yntdtsiykw","htrxfdrmjf","vaexftdqvt","xutdadkuaf","mxitdfddum","deflfxwtgt","xnjielfjuo","txuhndiefm","hamxtehxfd","zdmttfxlag","rutofxaehd","hiotdutxtf","gitcdddflx","diqvbqhlta","tdagtdxffp","zftixjdvtn","zlzdtlxxfn","djdftiapex","taacruwrjt","diwfkpxftq","cvrexhtrfd","fvpdxsfptu","zddijmfcgk","oaysztrnhr","xgftmlpkfd","zdxdxbcfft","edbfpxwvtp","tfkrdrxdra","osbdfwpxth","sfjxdtqpjg","aocnblxtac","xtllofodiy","gvfhxistdo","sijcfotdmx","bepuwjlncc","mtaxxdptfh","igxfdgftfh","ittxbdfdbn","cuwdswptfx","zfzxxtqcdt","nfmsgqhrsk","idtwxagfhb","wxpfdwvzst","toxctnfgod","lfnadtxdtr","wvlmjjkmzn","rtdldtcqfx","sbipqjdwxj","ikfxldtwpm","dotecxhwfx","zkfqxdglty","eqxefutmdb","tumrxgcdfx","tulflzgidx","nepifrvwwp","stbfcxdfyf","zhrtlilxqk","dxxdmhflit","dxfpaxtqcb","fpxtwfubdx","txdoypxbfn","tqxdjfdpku","wzlntxlcdf","rnundryglt","fckdewtdxt","fddqhxtxgw","onmkghjqpn","zdflrgtcxo","tfkslgdxks","thclfgjsnv","ndbxtfpcii","fhxdfftejb","qtvobgyfmp","tvwtjxxfdx","fjwoxdbkht","nhdtittwxf","pnorzcupgw","kvdffxcfon","jrwmdasndl","xqdfdjigft","fawaxdyuct","qjqofjytgl","wxtadlxkft","yxdhztfnmv","stxfdtydbg","pgytkxnfdz","qmuyoynahp","udtfboxudp","mgfmxntydr","skcpktyfxd","mxifdtobki","bcrobgiztf","blwztggriz","tbexjkyfkd","dxckftvidr","yxqtypfdel","cibjxhzmnj","yymypjaysm","fxdobkehdt","cbupcpdgxn","frfcvdgotx","yyodbiogea","dixdttqxff","vfstxbndph","ixjntwikdf","dsjxrgftdf","fkuxiddkjt","vnxhhsdoft","tcdmxftnkl","orqullwxdo","xudmztfhpa","fkqtxrvdfv","idgziinxft","awgurlhutf","rwqrgyvnll","yfdftlxxwm","ythdtnfxet","ocwxtpfwrd","prxstkfdfc","xydtfeedyl","fdxiyeiqet","opatpfdygx","tglfmxuifd","xntfdujjbz","bltrspuqie","vticqizacx","xnqkzuwean","gbfpedgmde","uaqwxtgpco","mzwsdfxast","quukakynno","euxfdftsuy","dftnmiqxeo","qdjxqaftfu","tkhldebhnv","hdxwbtafjt","dlirgzsaab","futupxxdzx","gtfdxjvoxj","fdpiskxava","ddyvcfrtxd","gxtfdueikp","tddmltfxun","dterixdofs","wewvhtiufb","detmfjsxiu","dtuikavzfx","itdmeublmx","hfkrwdiphr","dypfgxfvtm","cebbkiqcck","dtatmzlihq","fddtdqewxo","rtexdfybau","pfuxzltrvd","xxovefdotp","eiidjftxzt","gwxfinldrk","qdlxyswjro","lnfatmyqci","xtfnlpbddn","dffivtxdrp","aiteqywxfd","kjtaymhemb","dghdxdgozc","dwftwhejvx","xlnkrtpfdk","sxsdjktcff","izthshlzsx","dogtpmxsnf","fdkncytegx","fdtxgvhkfn","dttxyxfrxl","dequvqjxgy","txmxfbtycd","eufvdtmtzx","pcohmjadvr","rytlhksvrt","ocbtsfdxta","ffyqyhpssu","ylthfxdfxg","tjmxajdchf","vhhidnhuua","ndxwdlthxh","ajeqvrkhzf","krdonsovat","yreqaugyuv","mguixqjpuq","xtygftbkdu","flqdftkxsl","vdprutffxa","enxdjotmff","dxdzqhtfzk","xtcgftedfn","rxdlotdfmf","tljfxktzdl","thxdfycntn","xpjzooxhvq","binknlnqpn","idztqmfoxt","lxgtmhvdfm","dlxwhyetfz","nlgwkbjmwq","ighqszkiyk","ndebvciymq","ftphzxtqrd","mvedxafhft","aylkvskgud","nkuwxarjsn","ddfzdtxhlx","krehfzxzkc","oduxlgftgb","xifdoitnqg","ttjrswbfdx","axrfdsdxmt","zatdxzfteu","yxldyttxfz","unyhikiknq","dkxftvxdlm","lufoswqylp","snjsvfakwu","itcldxhtxf","fdsxdthrph","uumdpbtjxf","saehskvltd","rllezjywpl","tqdrdfgxuu","sggpdqllck","qormxgjquu","xdnbtsqkcf","xwfrfdtdtd","uuyhvorbnr","xfaftqsgzd","aotdiddzxf","sfxpaxbztd","tbguoatusg","xdexgtdifw","txxlfdziby","xtfgegdilt","lbkvcimojl","kutfxhdkdx","ktwwdxaqwf","qtoqwjvrnc","amxbrttfed","advafetixn","hcbfdtsubx","rddxotaspy","rqhomlpsef","dtdkfewxki","xzvtcnbdad","exmqxyddtf","fcqhvojvbu","tdqfwbmtux","wckhuwubtv","bovdxfdfnt","ytfexsfkdu","jhfjtjxdnx","hhqtifgdxe","tdftcadxpv","tvdhtdsxaf","mftuldgldx","xdxxtfknoj","dxpidtnkfi","xdozytfqat","ntsxkfdbet","jtxfdgcnjo","awqyecqdyr","ffupmkgdvv","fukhsrbfgr","odxcxdtfdo","pmxedfhytc","jjaftsdeka","fkxcbdxiit","eudueqwdcd","tdftxtfscb","mqgbambzve","qlfvxdfdht","obacooungh","fxvsdmctdx","dgtpvmqiwh","ioephhsspl","gvfrtssrhj","txofniadvt","fwqxxxdatp","mtfdxxrdcc","fahtqdxywc","dtfmiwxpvi","ogzygyeuaf","vmjxacebrd","sxdtkuxmif","bwncdactxf","fhsuixdtzh","gtxfjdxhtb","xgdctdfvyj","woypyldpmk","dhteldxtyf","ohhtefopbr","dlttfcoxrt","wapkluxhmy","cumxglzxux","cqftbvspua","aecngmxbwg","xttdukyfft","zxqdmlgjhp","tjgyxwjfdo","hxtzttxuiw","tuzxdxslzf","nxipdfdmtb","jxofdtodar","fnyytybdxr","dxitfjugpb","ptixzrdfdk","aqjelauzrl","fdxaskmtdt","obxtnfffkd","fqatfqdqlx","dxzorwinft","zvyxujhpgh","eqfrdmmfxt","fwtoaxdwdt","tfxstfddjq","fqvxozbpin","dfnttxedkb","xodudtgfew","fyxsmtodav","alrcudmxed","vvegirwdae","nybmrjchfu","cubkgaaayu","qvgxxnczop","kdfxsxeubt","adigfxutwx","xhmdwyacwe"},
//                        new String[]{"xdt","xdf","fd","x","d","fdt","df","fx","fx","fx","xt","t","xt","xft","d","x","tx","t","ftx","x","fx","fxd","td","dft","xd","f","dxf","t","x","xt","f","xf","dx","d","fd","df","t","dx","txd","d","d","xtf","fx","dxt","dft","fd","dx","tfx","td","t","tdf","fxd","x","x","dx","fdx","fd","x","x","fdt","f","tfx","fxd","dtf","tf","dt","dx","ftd","fx","xt","x","d","tf","f","d","d","xd","txd","fx","t","d","x","f","tfd","ftx","x","xdf","xdt","tfd","xd","xtd","xt","xdt","dxt","t","f","x","d","t","dfx","dx","f","ftd","x","xtf","dx","t","fd","dxf","fd","x","f","fd","xd","fxd","x","f","xdt","txd","f","t","d","dxt","dx","d","fd","dt","x","t","dft","t","tfd","tfx","xf","xft","dx","t","fd","dxf","xf","xf","ft","xtf","x","xd","tx","dx","tx","fx","xd","ft","txf","fx","tfd","f","xt","dx","tf","ft","df","ft","xf","tx","dt","f","tfx","tf","ft","dtx","t","xdt","ftx","f","xf","t","txf","dt","txd","t","fx","f","txf","xd","td","fxt","f","fx","fdt","x","x","f","tf","fd","f","t","d","xf","xf","txf","f","dx","tf","xft","ftd","dt","dxf","xd","d","t","xt","f","df","d","f","ft","tx","dxf","dx","dfx","df","ft","ft","d","d","d","x","dt","ft","td","dtx","d","tfd","d","t","x","x","tfd","df","d","d","fd","d","tf","txf","x","ftd","d","d","x","fdx","dx","txf","xdt","dft","txd","fxt","xt","dx","fdt","df","xft","d","tx","dx","fxt","d","x","df","f","dft","f","ftx","f","dt","df","xt","tx","dt","tx","ftd","d","d","f","x","t","f","ft","dtf","dtf","x","t","dx","dtx","tx","fdx","xd","xd","xfd","df","tf","xf","xd","dxt","dfx","xdf","xdf","xtf","xdt","f","xf","x","f","dx","xtf","dxf","d","dx","t","d","xdt","xtd","tx","dxf","dfx","d","dxf","td","dtf","tdx","tdf","df","t","xf","t","fx","d","t","fxd","tfx","d","txd","x","xt","xfd","dtf","x","dfx","td","f","ftx","d","d","t","t","x","ftd","xft","f","xtf","fx","tx","fd","tdx","dt","x","df","tf","ftd","f","d","xdf","ft","dtx","t","d","tfd","d","d","t","d","tf","txf","xd","tdx","xdf","xdt","t","xd","d","xfd","xf","td","t","fdx","tf","tf","xf","xft","ftd","x","t","xtf","f","txd","tfx","fd","dtx","f","tdx","tf","x","f","x","dfx","t","df","dt","x","ftd","x","txf","x","x","dfx","fdx","xfd","f","xtd","fd","xtf","fxt","txd","ftx","tdx","x","t","xd","tx","dx","f","dt","d","x","t","ft","fdt","t","fd","x","tfx","f","xft","dt","d","txf","fd","t","xf","td","tx","xdf","tfx","dft","dt","tfd","xd","x","dt","x","tdf","fxd","tf","td","t","f","fdx","d","d","t","x","tx","txd","fdt","f","d","tfd","fd","xdt","d","d","dt","td","t","xdt","txd","t","d","fdx","dxt","ft","f","t","t","d","f","xdf","tx","x","xf","tfd","d","xf","x","d","x","td","xdf","f","tfd","tf","f","x","t","f","x","x","tdx","ftd","xfd","t","x","d","fd","dtf","t","ft","t","xdf","tdx","dx","xd","ft","t","dtx","t","x","dxt","f","f","t","x","tx","d","xf","x","dtx","ftx","fxd","d","tfx","dx","dxt","x","dtx","t","d","ft","dtf","x","x","x","tfd","dft","x","dt","dxt","df","td","df","x","f","ftx","x","dxt","dft","xf","fxd","f","t","t","d","dfx","dt","dt","f","xd","tf","fx","df","xft","f","dt","df","xtd","fx","t","x","dfx","f","fdx","xf","dxf","t","fx","f","t","tdx","dtx","xdt","xft","f","fx","tf","txf","df","f","xfd","dtx","td","d","ft","xdf","xtf","df","d","t","d","tf","fx","xft","tx","dt","ft","xt","x","d","t","xdf","tf","xt","tf","ft","xt","f","dfx","f","xt","tfx","xtf","txd","d","xft","x","fx","dt","x","xt","d","f","d","f","d","df","f","x","txd","tfx","fd","txf","tdx","xdf","txf","xft","xd","xt","d","xt","tf","xf","d","d","xtf","tdf","x","tf","df","dtf","xt","dt","x","d","xtf","x","tfx","d","xtf","ftx","xft","tx","xf","tf","xft","fx","tx","tx","dxt","xd","dfx","t","df","x","xdf","t","d","dtx","fx","t","dx","dtf","f","td","t","f","tfd","f","ftd","tf","ft","fx","df","t","xft","xd","t","f","df","tx","t","t","d","t","xfd","df","f","txf","dxf","dt","d","ft","t","ft","dx","x","xdt","td","xdf","td","dt","d","d","xt","df","fd","xf","fxd","dxf","tfd","t","t","f","xt","xfd","dtf","dxf","xd","ft","txd","tdf","ftx","xft","f","tf","txf","x","txd","t","xf","td","tfx","xt","dt","tdx","dt","xdt","ft","fx","f","dxt","f","dx","fdt","dxt","dx","x","fdx","d","xd","ft","dx","t","f","ft","fx","xd","fx","fdx","d","xfd","f","xdt","x","tdx","dfx","d","xd","tdx","fdx","t","ftx","t","f","tdf","xdf","dft","x","tx","fxd","xtd","d","ft","tfx","d","xfd","df","fd","txf","tx","df","dtf","txd","xdt","t","t","dxt","txf","ft","df","fx","xt","txf","ft","fxt","f","df","dxt","fd","tx","dt","td","xdf","x","fx","xdt","dxt","ft","xf","f","dfx","fdt","ft","fxd","f","tx","ft","txf","ft","tf","ft","df","dt","f","xd","ft","tdx","xfd","f","df","dt","t","d","ftd","fdx","d","t","fdt","f","d","fxt","d","tfx","tx","xtd","t","xdt","x","d","ftx","f","f","xf","tf","df","ft","f","tf","td","fd","ftd","fdt","dtf","t","f","tf","f","dft","d","xd","t","f","xtf","x","x","xt","fx","xtf","fdx","f","fxd","t","tdx","x","ftd","x","d","x","tf","fd","x","dft","xtf","dft","xd","txf","ftx","dx","xdf","dx","tf","xf","dtx","t","dxt","tx","xft","xt","f","f","td","td","f","xft","fd","fx","xd","td","tf","tf","d","t","xft"}).toArray());
        assertArrayEquals(new String[]{"google","leetcode"},
                wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},
                        new String[]{"eo","lo"}).toArray());
        assertArrayEquals(new String[]{"facebook","google","leetcode"},
                wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},
                        new String[]{"e","o"}).toArray());
        assertArrayEquals(new String[]{"apple","google","leetcode"},
                wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},
                        new String[]{"l","e"}).toArray());
    }

    /*Example 1:

["amazon","apple","facebook","google","leetcode"]
["lo","eo"]
    Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
    Output: ["facebook","google","leetcode"]
    Example 2:

    Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
    Output: ["apple","google","leetcode"]*/
}
