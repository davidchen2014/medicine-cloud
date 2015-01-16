medicine-cloud
==============

系统建立在akka 2.3.8版本基础之上。
对外提供restful访问(jboss-resteasy)，对外提供批量数据加载，和数据展示功能。
系统采用akka-cluster构建， 工作节点使用cluster-pool方式动态创建。


-------------------------------------------------------------
<div class=WordSection1 style='layout-grid:15.6pt'>

<p class=MsoNormal><span style='font-family:宋体;mso-ascii-font-family:Calibri;
mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>大并发</span>
<span style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>实时数据处理解决方案：</span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoListParagraph style='margin-left:18.0pt;text-indent:-18.0pt;
mso-char-indent-count:0;mso-list:l1 level1 lfo1'><![if !supportLists]><span
lang=EN-US style='mso-fareast-font-family:Calibri;mso-fareast-theme-font:minor-latin;
mso-bidi-font-family:Calibri;mso-bidi-theme-font:minor-latin'><span
style='mso-list:Ignore'>1.<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></span><![endif]><span style='font-family:宋体;mso-ascii-font-family:
Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>架构</span></p>

<p class=MsoListParagraph style='margin-left:18.0pt;text-indent:0cm;mso-char-indent-count:
0'><span style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>整体系统采用分布式结构搭建，系统功能包括：</span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:-21.0pt;
mso-char-indent-count:0;mso-list:l2 level1 lfo2'><![if !supportLists]><span
lang=EN-US style='font-family:Wingdings;mso-fareast-font-family:Wingdings;
mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>&Oslash;<span
style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>对外提供海量数据的载入，测试结果会看到具体指标项</span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:-21.0pt;
mso-char-indent-count:0;mso-list:l2 level1 lfo2'><![if !supportLists]><span
lang=EN-US style='font-family:Wingdings;mso-fareast-font-family:Wingdings;
mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>&Oslash;<span
style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>海量数据查询功能</span></p>

<p class=MsoListParagraph style='margin-left:18.0pt;text-indent:0cm;mso-char-indent-count:
0'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoListParagraph style='margin-left:18.0pt;text-indent:0cm;mso-char-indent-count:
0'><span style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>此外系统本身具有如下特点：</span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:-21.0pt;
mso-char-indent-count:0;mso-list:l0 level1 lfo3'><![if !supportLists]><span
lang=EN-US style='font-family:Wingdings;mso-fareast-font-family:Wingdings;
mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>&Oslash;<span
style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>可扩展性，集群上面的节点有自定义的角色划分，并且各个角色可以实现动态搜索，</span>
<span style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>根据业务量增大或者缩小，可以动态添加或者减少节点数量。</span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:-21.0pt;
mso-char-indent-count:0;mso-list:l0 level1 lfo3'><![if !supportLists]><span
lang=EN-US style='font-family:Wingdings;mso-fareast-font-family:Wingdings;
mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>&Oslash;<span
style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>负载均衡：这里负载均衡的目的是为了减少单台服务器压力过大（尤其在网卡，内存方面）的情况。这里提供两种负载均衡：第一种针对后端倒入数据的节点：采用均衡</span><span
lang=EN-US> (</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>默认是</span><span
class=SpellE><span lang=EN-US>roundrobin</span></span><span lang=EN-US>)</span><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>方式动态发现，分派预定块数据。第二种针对前端结构请求端节点，也是采用均衡</span><span
lang=EN-US> (</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>默认是</span><span
class=SpellE><span lang=EN-US>roundrobin</span></span><span lang=EN-US>)</span><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>方式动态发起请求。</span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:-21.0pt;
mso-char-indent-count:0;mso-list:l0 level1 lfo3'><![if !supportLists]><span
lang=EN-US style='font-family:Wingdings;mso-fareast-font-family:Wingdings;
mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>&Oslash;<span
style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>故障转移：针对后端数据导入节点，系统采用定义了物理度量值功能，如果单节点不符合条件（比如</span><span
lang=EN-US>down</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>机，或者正在处理数据导致</span><span
class=SpellE><span lang=EN-US>cpu</span></span><span style='font-family:宋体;
mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:
宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
mso-hansi-theme-font:minor-latin'>，网络，内存等饱和）分发节点会动态选择其他候选节点来处理。</span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span style='font-family:宋体;
mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:
宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
mso-hansi-theme-font:minor-latin'>下图是系统的业务导向：</span></p>

<p class=MsoNormal align=center style='margin-left:18.0pt;text-align:center'><span
lang=EN-US><!--[if gte vml 1]><v:shapetype id="_x0000_t75" coordsize="21600,21600"
 o:spt="75" o:preferrelative="t" path="m@4@5l@4@11@9@11@9@5xe" filled="f"
 stroked="f">
 <v:stroke joinstyle="miter"/>
 <v:formulas>
  <v:f eqn="if lineDrawn pixelLineWidth 0"/>
  <v:f eqn="sum @0 1 0"/>
  <v:f eqn="sum 0 0 @1"/>
  <v:f eqn="prod @2 1 2"/>
  <v:f eqn="prod @3 21600 pixelWidth"/>
  <v:f eqn="prod @3 21600 pixelHeight"/>
  <v:f eqn="sum @0 0 1"/>
  <v:f eqn="prod @6 1 2"/>
  <v:f eqn="prod @7 21600 pixelWidth"/>
  <v:f eqn="sum @8 21600 0"/>
  <v:f eqn="prod @7 21600 pixelHeight"/>
  <v:f eqn="sum @10 21600 0"/>
 </v:formulas>
 <v:path o:extrusionok="f" gradientshapeok="t" o:connecttype="rect"/>
 <o:lock v:ext="edit" aspectratio="t"/>
</v:shapetype><v:shape id="_x0000_i1025" type="#_x0000_t75" style='width:276.75pt;
 height:225pt' o:ole="">
 <v:imagedata src="doc/imgs/image001.emz" o:title=""/>
</v:shape><![endif]--><![if !vml]><img width=369 height=300
src="doc/imgs/image002.gif" v:shapes="_x0000_i1025"><![endif]><!--[if gte mso 9]><xml>
 <o:OLEObject Type="Embed" ProgID="Visio.Drawing.11" ShapeID="_x0000_i1025"
  DrawAspect="Content" ObjectID="_1482908633">
 </o:OLEObject>
</xml><![endif]--></span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span style='font-family:宋体;
mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:
宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
mso-hansi-theme-font:minor-latin'>客户端可以发起标准的</span><span lang=EN-US>http-rest</span><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>请求来调用系统，此外也可以使用客户端程序来调用系统。在部署架构上来讲，如果使用</span><span
lang=EN-US>http-rest</span><span style='font-family:宋体;mso-ascii-font-family:
Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>方式，需要在分布式系统前段再部署一层</span><span
lang=EN-US>http</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>负载均衡软件（比如</span><span
class=SpellE><span lang=EN-US>nginx,haproxy</span></span><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>等等）。如果使用客户端程序的话那么不需要加装</span><span
lang=EN-US>http</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>负责均衡层，客户端程序本身自带负载均衡策略。</span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span style='font-family:宋体;
mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:
宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
mso-hansi-theme-font:minor-latin'>数据库端我们目前采用</span><span class=SpellE><span
lang=EN-US>hadoop-hbase</span></span><span style='font-family:宋体;mso-ascii-font-family:
Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>作为存储解决方案，可以使用其它系统动态替换。</span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span style='font-family:宋体;
mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:
宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
mso-hansi-theme-font:minor-latin'>系统分为以下</span><span lang=EN-US>4</span><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>种角色：</span></p>

<p class=MsoListParagraph align=center style='margin-left:18.0pt;text-align:
center;text-indent:0cm;mso-char-indent-count:0;page-break-after:avoid'><span
lang=EN-US><!--[if gte vml 1]><v:shape id="_x0000_i1026" type="#_x0000_t75"
 style='width:4in;height:204pt' o:ole="">
 <v:imagedata src="doc/imgs/image003.emz" o:title=""/>
</v:shape><![endif]--><![if !vml]><img width=384 height=272
src="doc/imgs/image004.gif" v:shapes="_x0000_i1026"><![endif]><!--[if gte mso 9]><xml>
 <o:OLEObject Type="Embed" ProgID="Visio.Drawing.11" ShapeID="_x0000_i1026"
  DrawAspect="Content" ObjectID="_1482908634">
 </o:OLEObject>
</xml><![endif]--></span></p>

<p class=MsoCaption align=center style='text-align:center'><span
style='font-family:黑体;mso-ascii-font-family:Cambria;mso-ascii-theme-font:major-latin;
mso-hansi-font-family:Cambria;mso-hansi-theme-font:major-latin'>系统角色划分</span></p>

<p class=MsoNormal align=center style='text-align:center'><b style='mso-bidi-font-weight:
normal'><span style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;color:red'>备注：各个角色的之间通讯都使用异步通讯方式，极大提升了</span><span
class=SpellE><span lang=EN-US style='color:red'>cpu</span></span></b><b
style='mso-bidi-font-weight:normal'><span style='font-family:宋体;mso-ascii-font-family:
Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;
color:red'>的利用率以及系统的吞吐率</span><span lang=EN-US style='color:red'><o:p></o:p></span></b></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:-21.0pt;
mso-char-indent-count:0;mso-list:l3 level1 lfo4'><![if !supportLists]><span
lang=EN-US style='font-family:Wingdings;mso-fareast-font-family:Wingdings;
mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>&Oslash;<span
style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>业务节点</span><span lang=EN-US>(master) </span><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>：是系统的业务前段，负责对外接受数据，分派任务给工作节点。</span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:0cm;mso-char-indent-count:
0'><span style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>这里简单图示下</span><span
lang=EN-US>master</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>节点：</span></p>

<p class=MsoListParagraph align=left style='margin-left:39.0pt;text-align:left;
text-indent:0cm;mso-char-indent-count:0'><span lang=EN-US><!--[if gte vml 1]><v:shape
 id="_x0000_i1027" type="#_x0000_t75" style='width:414.75pt;height:218.25pt'
 o:ole="">
 <v:imagedata src="doc/imgs/image005.emz" o:title=""/>
</v:shape><![endif]--><![if !vml]><img width=553 height=291
src="doc/imgs/image006.gif" v:shapes="_x0000_i1027"><![endif]><!--[if gte mso 9]><xml>
 <o:OLEObject Type="Embed" ProgID="Visio.Drawing.11" ShapeID="_x0000_i1027"
  DrawAspect="Content" ObjectID="_1482908635">
 </o:OLEObject>
</xml><![endif]--></span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:0cm;mso-char-indent-count:
0'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:-21.0pt;
mso-char-indent-count:0;mso-list:l3 level1 lfo4'><![if !supportLists]><span
lang=EN-US style='font-family:Wingdings;mso-fareast-font-family:Wingdings;
mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>&Oslash;<span
style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>工作节点</span><span lang=EN-US>(worker) </span><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>：是系统的具体工作节点，负责处理具体的业务，这里当然就是导入数据啦。</span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:0cm;mso-char-indent-count:
0'><span style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>这里简单图示下</span><span
lang=EN-US>worker</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>节点：</span></p>

<p class=MsoNormal style='margin-left:18.0pt'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:0cm;mso-char-indent-count:
0'><span lang=EN-US><!--[if gte vml 1]><v:shape id="_x0000_i1028" type="#_x0000_t75"
 style='width:323.25pt;height:181.5pt' o:ole="">
 <v:imagedata src="doc/imgs/image007.emz" o:title=""/>
</v:shape><![endif]--><![if !vml]><img width=431 height=242
src="doc/imgs/image008.gif" v:shapes="_x0000_i1028"><![endif]><!--[if gte mso 9]><xml>
 <o:OLEObject Type="Embed" ProgID="Visio.Drawing.11" ShapeID="_x0000_i1028"
  DrawAspect="Content" ObjectID="_1482908636">
 </o:OLEObject>
</xml><![endif]--></span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:-21.0pt;
mso-char-indent-count:0;mso-list:l3 level1 lfo4'><![if !supportLists]><span
lang=EN-US style='font-family:Wingdings;mso-fareast-font-family:Wingdings;
mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>&Oslash;<span
style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>管理节点</span><span lang=EN-US>(seed)</span><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>：集群内部管理节点，必须存在一个以上的</span><span
lang=EN-US>seed</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>节点，这样集群才能正常运行。运<span
class=GramE>维人员</span>可以查看该节点数据来观察集群的健康状况。</span></p>

<p class=MsoListParagraph style='margin-left:39.0pt;text-indent:-21.0pt;
mso-char-indent-count:0;mso-list:l3 level1 lfo4'><![if !supportLists]><span
lang=EN-US style='font-family:Wingdings;mso-fareast-font-family:Wingdings;
mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>&Oslash;<span
style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>监控节点</span><span lang=EN-US>(monitor)</span><span
style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;
mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:
Calibri;mso-hansi-theme-font:minor-latin'>：集群管理节点，可以监控集群节点的状况（包括：活动，停顿，在工作等等情况）系统默认采用日志输出的方式，但也可以接入第三方软件实现动态监控。</span></p>

<p class=MsoNormal style='margin-left:18.0pt'><b style='mso-bidi-font-weight:
normal'><span style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;color:red'>备注：以上角色定义都是自定义，可以根据需要自定义其它角色</span></b></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoListParagraph style='margin-left:18.0pt;text-indent:-18.0pt;
mso-char-indent-count:0;mso-list:l1 level1 lfo1'><![if !supportLists]><span
lang=EN-US style='mso-fareast-font-family:Calibri;mso-fareast-theme-font:minor-latin;
mso-bidi-font-family:Calibri;mso-bidi-theme-font:minor-latin'><span
style='mso-list:Ignore'>2.<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></span><![endif]><span style='font-family:宋体;mso-ascii-font-family:
Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>测试结果</span></p>

<p class=MsoListParagraph align=left style='margin-left:18.0pt;text-align:left;
text-indent:0cm;mso-char-indent-count:0;mso-pagination:widow-orphan'><span
lang=EN-US style='mso-font-kerning:0pt;mso-no-proof:yes'><!--[if gte vml 1]><v:shape
 id="图片_x0020_7" o:spid="_x0000_i1029" type="#_x0000_t75" style='width:450.75pt;
 height:266.25pt;visibility:visible;mso-wrap-style:square'>
 <v:imagedata src="doc/imgs/image009.jpg" o:title="GE[QTI5Q~$)34~UQ}TW8N)1"/>
</v:shape><![endif]--><![if !vml]><img width=601 height=355
src="doc/imgs/image009.jpg" v:shapes="图片_x0020_7"><![endif]></span><span
lang=EN-US style='font-size:12.0pt;font-family:宋体;mso-bidi-font-family:宋体;
mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoListParagraph align=left style='margin-left:18.0pt;text-align:left;
text-indent:0cm;mso-char-indent-count:0;mso-pagination:widow-orphan'><span
style='font-size:12.0pt;font-family:宋体;mso-bidi-font-family:宋体;mso-font-kerning:
0pt'>这里展示的使用<span lang=EN-US>20</span>万测试数据（根据业务需要的模拟数据）的测试结果，测试方式采用客户端<span
lang=EN-US>http-rest</span>方式，分别采用每<span lang=EN-US>500</span>，<span
lang=EN-US>1000</span>，<span lang=EN-US>2000</span>，<span lang=EN-US>2500</span>，<span
lang=EN-US>5000</span><span class=GramE>一个</span>数据包发送系统对外总耗时情况。从图上看出<span
lang=EN-US>1000</span>条批次的耗时<span lang=EN-US>100</span>秒左右是最优的。<span
lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoListParagraph style='margin-left:18.0pt;text-indent:0cm;mso-char-indent-count:
0'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoListParagraph style='margin-left:18.0pt;text-indent:0cm;mso-char-indent-count:
0'><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

</div>
-------------------------------------------------------------------------


scale-out模式下配置的启动参数如下：

java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_master.log -jar medicine-master.jar 10.1.65.104 2570 > master.log &

java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_seed.log  -jar medicine-seed.jar 10.1.65.106 2551 > seed.log &

java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_seed.log  -jar medicine-seed.jar 10.1.65.107 2551 > seed.log &

java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_worker.log  -jar medicine-worker.jar 10.1.65.106 2580 > worker.log &

java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_worker.log  -jar medicine-worker.jar 10.1.65.107 2580 > worker.log &



