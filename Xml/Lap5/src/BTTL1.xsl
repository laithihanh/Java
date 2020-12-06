<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BTTL1.xsl
    Created on : August 21, 2020, 3:05 PM
    Author     : ADMIN
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>BTTL1.xsl</title>
            </head>
            <body>
                <table border="1" width="40%" style="margin:auto">
                    <tr bgcolor="#9acd32">
                        <th style="text-align:center">Sân</th>
                        <th style="text-align:center">Ngày</th>
                        <th style="text-align:center">Đội 1</th>
                        <th style="text-align:center">Số bk</th>
                        <th style="text-align:center">Đội 2</th>
                        <th style="text-align:center">Số bt</th>
                    </tr>
                    <xsl:for-each select="football/ball">
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="name"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="time"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="team"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="bt"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="team1"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="bt1"/>
                        </td>
                    </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
