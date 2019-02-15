<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="text" indent="yes"  encoding="UTF-8" />
    <xsl:strip-space elements="*"/>

    <xsl:template match="/" xml:space="default">
        <xsl:for-each select="/*/*"><xsl:value-of select="local-name()" />: <xsl:value-of select="text()" />, </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>