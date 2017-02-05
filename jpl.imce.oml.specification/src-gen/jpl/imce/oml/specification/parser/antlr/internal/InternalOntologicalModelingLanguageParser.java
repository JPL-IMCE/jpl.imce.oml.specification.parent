package jpl.imce.oml.specification.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import jpl.imce.oml.specification.services.OntologicalModelingLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOntologicalModelingLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ANNOTATION_PROPERTY_TOKEN", "RULE_EQUAL", "RULE_IRI", "RULE_ANNOTATION_TOKEN", "RULE_STRING", "RULE_TERMINOLOGY_GRAPH_TOKEN", "RULE_LCURLY", "RULE_RCURLY", "RULE_BUNDLE_TOKEN", "RULE_ASPECT_TOKEN", "RULE_ID", "RULE_ABSTRACT_TOKEN", "RULE_CONCEPT_TOKEN", "RULE_REIFIED_RELATIONSHIP_TOKEN", "RULE_FUNCTIONAL_TOKEN", "RULE_INVERSE_FUNCTIONAL_TOKEN", "RULE_ESSENTIAL_TOKEN", "RULE_INVERSE_ESSENTIAL_TOKEN", "RULE_SYMMETRIC_TOKEN", "RULE_ASYMMETRIC_TOKEN", "RULE_REFLEXIVE_TOKEN", "RULE_IRREFLEXIVE_TOKEN", "RULE_TRANSITIVE_TOKEN", "RULE_UNREIFIED_TOKEN", "RULE_INVERSE_TOKEN", "RULE_SOURCE_TOKEN", "RULE_TARGET_TOKEN", "RULE_UNREIFIED_RELATIONSHIP_TOKEN", "RULE_SCALAR_TOKEN", "RULE_STRUCTURE_TOKEN", "RULE_DOMAIN_TOKEN", "RULE_RANGE_TOKEN", "RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN", "RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN", "RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN", "RULE_BUNDLED_TERMINOLOGY_AXIOM_TOKEN", "RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN", "RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN", "RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN", "RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN", "RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN", "RULE_ASPECT_SPECIALIZATION_AXIOM_TOKEN", "RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN", "RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN", "RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN", "RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN", "RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN", "RULE_BINARY_SCALAR_RESTRICTION_TOKEN", "RULE_INT", "RULE_IRI_SCALAR_RESTRICTION_TOKEN", "RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN", "RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN", "RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN", "RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN", "RULE_STRING_SCALAR_RESTRICTION_TOKEN", "RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN", "RULE_TIME_SCALAR_RESTRICTION_TOKEN", "RULE_KIND_TOKEN", "RULE_HEX_8DIGITS", "RULE_HEX_4DIGITS", "RULE_HEX_12DIGITS", "RULE_UUID", "RULE_HEX_DIGIT", "RULE_HEX", "RULE_DECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entityStructuredDataProperty'", "'entityScalarDataProperty'", "'structuredDataProperty'", "'scalarDataProperty'", "'disjointTaxonomyParent'", "'root'", "'disjointLeaf'", "'bundledTerminology'", "'designatedTerminology'", "'designatedConcept'", "'nestingTerminology'", "'nestingContext'", "'restrictedRelation'", "'restrictedRange'", "'restrictedDomain'", "'subConcept'", "'superConcept'", "'subRelationship'", "'superRelationship'", "'restrictedEntity'", "'scalarProperty'", "'scalarRestriction'", "'literalValue'", "'length'", "'minLength'", "'maxLength'", "'pattern'", "'minInclusive'", "'maxInclusive'", "'minExclusive'", "'maxExclusive'", "'language'", "'value'", "'axiom'", "':'", "'open'", "'closed'"
    };
    public static final int RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN=40;
    public static final int RULE_HEX=67;
    public static final int RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN=56;
    public static final int RULE_LCURLY=10;
    public static final int RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN=54;
    public static final int RULE_REFLEXIVE_TOKEN=24;
    public static final int RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN=43;
    public static final int RULE_EQUAL=5;
    public static final int RULE_ID=14;
    public static final int RULE_BUNDLED_TERMINOLOGY_AXIOM_TOKEN=39;
    public static final int RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN=59;
    public static final int RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN=50;
    public static final int RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN=46;
    public static final int RULE_TRANSITIVE_TOKEN=26;
    public static final int RULE_FUNCTIONAL_TOKEN=18;
    public static final int RULE_ABSTRACT_TOKEN=15;
    public static final int RULE_UUID=65;
    public static final int RULE_INT=52;
    public static final int RULE_ML_COMMENT=69;
    public static final int RULE_REIFIED_RELATIONSHIP_TOKEN=17;
    public static final int RULE_INVERSE_TOKEN=28;
    public static final int RULE_CONCEPT_TOKEN=16;
    public static final int RULE_IRI=6;
    public static final int RULE_BUNDLE_TOKEN=12;
    public static final int RULE_TARGET_TOKEN=30;
    public static final int RULE_TERMINOLOGY_GRAPH_TOKEN=9;
    public static final int RULE_INVERSE_FUNCTIONAL_TOKEN=19;
    public static final int RULE_HEX_DIGIT=66;
    public static final int RULE_HEX_8DIGITS=62;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN=42;
    public static final int RULE_HEX_12DIGITS=64;
    public static final int RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN=49;
    public static final int RULE_STRUCTURE_TOKEN=33;
    public static final int T__99=99;
    public static final int RULE_BINARY_SCALAR_RESTRICTION_TOKEN=51;
    public static final int RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN=47;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN=57;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_ANNOTATION_TOKEN=7;
    public static final int RULE_SOURCE_TOKEN=29;
    public static final int RULE_UNREIFIED_RELATIONSHIP_TOKEN=31;
    public static final int RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN=37;
    public static final int RULE_ASPECT_SPECIALIZATION_AXIOM_TOKEN=45;
    public static final int RULE_TIME_SCALAR_RESTRICTION_TOKEN=60;
    public static final int RULE_KIND_TOKEN=61;
    public static final int RULE_DECIMAL=68;
    public static final int RULE_SCALAR_TOKEN=32;
    public static final int RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN=55;
    public static final int RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN=48;
    public static final int RULE_IRI_SCALAR_RESTRICTION_TOKEN=53;
    public static final int RULE_RANGE_TOKEN=35;
    public static final int RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN=41;
    public static final int RULE_UNREIFIED_TOKEN=27;
    public static final int RULE_STRING=8;
    public static final int RULE_STRING_SCALAR_RESTRICTION_TOKEN=58;
    public static final int RULE_SL_COMMENT=70;
    public static final int RULE_INVERSE_ESSENTIAL_TOKEN=21;
    public static final int RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN=44;
    public static final int RULE_ANNOTATION_PROPERTY_TOKEN=4;
    public static final int RULE_SYMMETRIC_TOKEN=22;
    public static final int T__77=77;
    public static final int RULE_DOMAIN_TOKEN=34;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int RULE_HEX_4DIGITS=63;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN=38;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_IRREFLEXIVE_TOKEN=25;
    public static final int RULE_RCURLY=11;
    public static final int RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN=36;
    public static final int RULE_WS=71;
    public static final int RULE_ANY_OTHER=72;
    public static final int RULE_ASPECT_TOKEN=13;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int RULE_ESSENTIAL_TOKEN=20;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;
    public static final int RULE_ASYMMETRIC_TOKEN=23;

    // delegates
    // delegators


        public InternalOntologicalModelingLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOntologicalModelingLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOntologicalModelingLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOntologicalModelingLanguage.g"; }



     	private OntologicalModelingLanguageGrammarAccess grammarAccess;

        public InternalOntologicalModelingLanguageParser(TokenStream input, OntologicalModelingLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "TerminologyExtent";
       	}

       	@Override
       	protected OntologicalModelingLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTerminologyExtent"
    // InternalOntologicalModelingLanguage.g:78:1: entryRuleTerminologyExtent returns [EObject current=null] : iv_ruleTerminologyExtent= ruleTerminologyExtent EOF ;
    public final EObject entryRuleTerminologyExtent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyExtent = null;


        try {
            // InternalOntologicalModelingLanguage.g:78:58: (iv_ruleTerminologyExtent= ruleTerminologyExtent EOF )
            // InternalOntologicalModelingLanguage.g:79:2: iv_ruleTerminologyExtent= ruleTerminologyExtent EOF
            {
             newCompositeNode(grammarAccess.getTerminologyExtentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyExtent=ruleTerminologyExtent();

            state._fsp--;

             current =iv_ruleTerminologyExtent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyExtent"


    // $ANTLR start "ruleTerminologyExtent"
    // InternalOntologicalModelingLanguage.g:85:1: ruleTerminologyExtent returns [EObject current=null] : ( () ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) )* ( (lv_terminologyGraphs_2_0= ruleTerminologyGraph ) )* ( (lv_bundles_3_0= ruleBundle ) )* ) ;
    public final EObject ruleTerminologyExtent() throws RecognitionException {
        EObject current = null;

        EObject lv_annotationProperties_1_0 = null;

        EObject lv_terminologyGraphs_2_0 = null;

        EObject lv_bundles_3_0 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:91:2: ( ( () ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) )* ( (lv_terminologyGraphs_2_0= ruleTerminologyGraph ) )* ( (lv_bundles_3_0= ruleBundle ) )* ) )
            // InternalOntologicalModelingLanguage.g:92:2: ( () ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) )* ( (lv_terminologyGraphs_2_0= ruleTerminologyGraph ) )* ( (lv_bundles_3_0= ruleBundle ) )* )
            {
            // InternalOntologicalModelingLanguage.g:92:2: ( () ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) )* ( (lv_terminologyGraphs_2_0= ruleTerminologyGraph ) )* ( (lv_bundles_3_0= ruleBundle ) )* )
            // InternalOntologicalModelingLanguage.g:93:3: () ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) )* ( (lv_terminologyGraphs_2_0= ruleTerminologyGraph ) )* ( (lv_bundles_3_0= ruleBundle ) )*
            {
            // InternalOntologicalModelingLanguage.g:93:3: ()
            // InternalOntologicalModelingLanguage.g:94:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTerminologyExtentAccess().getTerminologyExtentAction_0(),
            					current);
            			

            }

            // InternalOntologicalModelingLanguage.g:100:3: ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ANNOTATION_PROPERTY_TOKEN) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOntologicalModelingLanguage.g:101:4: (lv_annotationProperties_1_0= ruleAnnotationProperty )
            	    {
            	    // InternalOntologicalModelingLanguage.g:101:4: (lv_annotationProperties_1_0= ruleAnnotationProperty )
            	    // InternalOntologicalModelingLanguage.g:102:5: lv_annotationProperties_1_0= ruleAnnotationProperty
            	    {

            	    					newCompositeNode(grammarAccess.getTerminologyExtentAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_annotationProperties_1_0=ruleAnnotationProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminologyExtentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotationProperties",
            	    						lv_annotationProperties_1_0,
            	    						"jpl.imce.oml.specification.OntologicalModelingLanguage.AnnotationProperty");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalOntologicalModelingLanguage.g:119:3: ( (lv_terminologyGraphs_2_0= ruleTerminologyGraph ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==108) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==RULE_TERMINOLOGY_GRAPH_TOKEN) ) {
                        alt2=1;
                    }


                }
                else if ( (LA2_0==109) ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2==RULE_TERMINOLOGY_GRAPH_TOKEN) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // InternalOntologicalModelingLanguage.g:120:4: (lv_terminologyGraphs_2_0= ruleTerminologyGraph )
            	    {
            	    // InternalOntologicalModelingLanguage.g:120:4: (lv_terminologyGraphs_2_0= ruleTerminologyGraph )
            	    // InternalOntologicalModelingLanguage.g:121:5: lv_terminologyGraphs_2_0= ruleTerminologyGraph
            	    {

            	    					newCompositeNode(grammarAccess.getTerminologyExtentAccess().getTerminologyGraphsTerminologyGraphParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_terminologyGraphs_2_0=ruleTerminologyGraph();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminologyExtentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"terminologyGraphs",
            	    						lv_terminologyGraphs_2_0,
            	    						"jpl.imce.oml.specification.OntologicalModelingLanguage.TerminologyGraph");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalOntologicalModelingLanguage.g:138:3: ( (lv_bundles_3_0= ruleBundle ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=108 && LA3_0<=109)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalOntologicalModelingLanguage.g:139:4: (lv_bundles_3_0= ruleBundle )
            	    {
            	    // InternalOntologicalModelingLanguage.g:139:4: (lv_bundles_3_0= ruleBundle )
            	    // InternalOntologicalModelingLanguage.g:140:5: lv_bundles_3_0= ruleBundle
            	    {

            	    					newCompositeNode(grammarAccess.getTerminologyExtentAccess().getBundlesBundleParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_bundles_3_0=ruleBundle();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminologyExtentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"bundles",
            	    						lv_bundles_3_0,
            	    						"jpl.imce.oml.specification.OntologicalModelingLanguage.Bundle");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyExtent"


    // $ANTLR start "entryRuleAnnotationProperty"
    // InternalOntologicalModelingLanguage.g:161:1: entryRuleAnnotationProperty returns [EObject current=null] : iv_ruleAnnotationProperty= ruleAnnotationProperty EOF ;
    public final EObject entryRuleAnnotationProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationProperty = null;


        try {
            // InternalOntologicalModelingLanguage.g:161:59: (iv_ruleAnnotationProperty= ruleAnnotationProperty EOF )
            // InternalOntologicalModelingLanguage.g:162:2: iv_ruleAnnotationProperty= ruleAnnotationProperty EOF
            {
             newCompositeNode(grammarAccess.getAnnotationPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationProperty=ruleAnnotationProperty();

            state._fsp--;

             current =iv_ruleAnnotationProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotationProperty"


    // $ANTLR start "ruleAnnotationProperty"
    // InternalOntologicalModelingLanguage.g:168:1: ruleAnnotationProperty returns [EObject current=null] : (this_ANNOTATION_PROPERTY_TOKEN_0= RULE_ANNOTATION_PROPERTY_TOKEN ( (lv_abbrevIRI_1_0= ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_iri_3_0= RULE_IRI ) ) ) ;
    public final EObject ruleAnnotationProperty() throws RecognitionException {
        EObject current = null;

        Token this_ANNOTATION_PROPERTY_TOKEN_0=null;
        Token this_EQUAL_2=null;
        Token lv_iri_3_0=null;
        AntlrDatatypeRuleToken lv_abbrevIRI_1_0 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:174:2: ( (this_ANNOTATION_PROPERTY_TOKEN_0= RULE_ANNOTATION_PROPERTY_TOKEN ( (lv_abbrevIRI_1_0= ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_iri_3_0= RULE_IRI ) ) ) )
            // InternalOntologicalModelingLanguage.g:175:2: (this_ANNOTATION_PROPERTY_TOKEN_0= RULE_ANNOTATION_PROPERTY_TOKEN ( (lv_abbrevIRI_1_0= ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_iri_3_0= RULE_IRI ) ) )
            {
            // InternalOntologicalModelingLanguage.g:175:2: (this_ANNOTATION_PROPERTY_TOKEN_0= RULE_ANNOTATION_PROPERTY_TOKEN ( (lv_abbrevIRI_1_0= ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_iri_3_0= RULE_IRI ) ) )
            // InternalOntologicalModelingLanguage.g:176:3: this_ANNOTATION_PROPERTY_TOKEN_0= RULE_ANNOTATION_PROPERTY_TOKEN ( (lv_abbrevIRI_1_0= ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_iri_3_0= RULE_IRI ) )
            {
            this_ANNOTATION_PROPERTY_TOKEN_0=(Token)match(input,RULE_ANNOTATION_PROPERTY_TOKEN,FOLLOW_5); 

            			newLeafNode(this_ANNOTATION_PROPERTY_TOKEN_0, grammarAccess.getAnnotationPropertyAccess().getANNOTATION_PROPERTY_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:180:3: ( (lv_abbrevIRI_1_0= ruleABBREV_IRI ) )
            // InternalOntologicalModelingLanguage.g:181:4: (lv_abbrevIRI_1_0= ruleABBREV_IRI )
            {
            // InternalOntologicalModelingLanguage.g:181:4: (lv_abbrevIRI_1_0= ruleABBREV_IRI )
            // InternalOntologicalModelingLanguage.g:182:5: lv_abbrevIRI_1_0= ruleABBREV_IRI
            {

            					newCompositeNode(grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIABBREV_IRIParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_abbrevIRI_1_0=ruleABBREV_IRI();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAnnotationPropertyRule());
            					}
            					set(
            						current,
            						"abbrevIRI",
            						lv_abbrevIRI_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ABBREV_IRI");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EQUAL_2=(Token)match(input,RULE_EQUAL,FOLLOW_7); 

            			newLeafNode(this_EQUAL_2, grammarAccess.getAnnotationPropertyAccess().getEQUALTerminalRuleCall_2());
            		
            // InternalOntologicalModelingLanguage.g:203:3: ( (lv_iri_3_0= RULE_IRI ) )
            // InternalOntologicalModelingLanguage.g:204:4: (lv_iri_3_0= RULE_IRI )
            {
            // InternalOntologicalModelingLanguage.g:204:4: (lv_iri_3_0= RULE_IRI )
            // InternalOntologicalModelingLanguage.g:205:5: lv_iri_3_0= RULE_IRI
            {
            lv_iri_3_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

            					newLeafNode(lv_iri_3_0, grammarAccess.getAnnotationPropertyAccess().getIriIRITerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_3_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.IRI");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationProperty"


    // $ANTLR start "entryRuleAnnotation"
    // InternalOntologicalModelingLanguage.g:225:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalOntologicalModelingLanguage.g:225:51: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalOntologicalModelingLanguage.g:226:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalOntologicalModelingLanguage.g:232:1: ruleAnnotation returns [EObject current=null] : (this_ANNOTATION_TOKEN_0= RULE_ANNOTATION_TOKEN ( ( ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token this_ANNOTATION_TOKEN_0=null;
        Token this_EQUAL_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:238:2: ( (this_ANNOTATION_TOKEN_0= RULE_ANNOTATION_TOKEN ( ( ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_value_3_0= RULE_STRING ) ) ) )
            // InternalOntologicalModelingLanguage.g:239:2: (this_ANNOTATION_TOKEN_0= RULE_ANNOTATION_TOKEN ( ( ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // InternalOntologicalModelingLanguage.g:239:2: (this_ANNOTATION_TOKEN_0= RULE_ANNOTATION_TOKEN ( ( ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_value_3_0= RULE_STRING ) ) )
            // InternalOntologicalModelingLanguage.g:240:3: this_ANNOTATION_TOKEN_0= RULE_ANNOTATION_TOKEN ( ( ruleABBREV_IRI ) ) this_EQUAL_2= RULE_EQUAL ( (lv_value_3_0= RULE_STRING ) )
            {
            this_ANNOTATION_TOKEN_0=(Token)match(input,RULE_ANNOTATION_TOKEN,FOLLOW_5); 

            			newLeafNode(this_ANNOTATION_TOKEN_0, grammarAccess.getAnnotationAccess().getANNOTATION_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:244:3: ( ( ruleABBREV_IRI ) )
            // InternalOntologicalModelingLanguage.g:245:4: ( ruleABBREV_IRI )
            {
            // InternalOntologicalModelingLanguage.g:245:4: ( ruleABBREV_IRI )
            // InternalOntologicalModelingLanguage.g:246:5: ruleABBREV_IRI
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyCrossReference_1_0());
            				
            pushFollow(FOLLOW_6);
            ruleABBREV_IRI();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EQUAL_2=(Token)match(input,RULE_EQUAL,FOLLOW_8); 

            			newLeafNode(this_EQUAL_2, grammarAccess.getAnnotationAccess().getEQUALTerminalRuleCall_2());
            		
            // InternalOntologicalModelingLanguage.g:264:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOntologicalModelingLanguage.g:265:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOntologicalModelingLanguage.g:265:4: (lv_value_3_0= RULE_STRING )
            // InternalOntologicalModelingLanguage.g:266:5: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_3_0, grammarAccess.getAnnotationAccess().getValueSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_3_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleTerminologyGraph"
    // InternalOntologicalModelingLanguage.g:286:1: entryRuleTerminologyGraph returns [EObject current=null] : iv_ruleTerminologyGraph= ruleTerminologyGraph EOF ;
    public final EObject entryRuleTerminologyGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyGraph = null;


        try {
            // InternalOntologicalModelingLanguage.g:286:57: (iv_ruleTerminologyGraph= ruleTerminologyGraph EOF )
            // InternalOntologicalModelingLanguage.g:287:2: iv_ruleTerminologyGraph= ruleTerminologyGraph EOF
            {
             newCompositeNode(grammarAccess.getTerminologyGraphRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyGraph=ruleTerminologyGraph();

            state._fsp--;

             current =iv_ruleTerminologyGraph; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyGraph"


    // $ANTLR start "ruleTerminologyGraph"
    // InternalOntologicalModelingLanguage.g:293:1: ruleTerminologyGraph returns [EObject current=null] : ( ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_TERMINOLOGY_GRAPH_TOKEN_1= RULE_TERMINOLOGY_GRAPH_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* this_RCURLY_7= RULE_RCURLY ) ;
    public final EObject ruleTerminologyGraph() throws RecognitionException {
        EObject current = null;

        Token this_TERMINOLOGY_GRAPH_TOKEN_1=null;
        Token lv_iri_2_0=null;
        Token this_LCURLY_3=null;
        Token this_RCURLY_7=null;
        Enumerator lv_kind_0_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_terminologyBoxAxioms_5_0 = null;

        EObject lv_boxStatements_6_0 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:299:2: ( ( ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_TERMINOLOGY_GRAPH_TOKEN_1= RULE_TERMINOLOGY_GRAPH_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* this_RCURLY_7= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:300:2: ( ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_TERMINOLOGY_GRAPH_TOKEN_1= RULE_TERMINOLOGY_GRAPH_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* this_RCURLY_7= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:300:2: ( ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_TERMINOLOGY_GRAPH_TOKEN_1= RULE_TERMINOLOGY_GRAPH_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* this_RCURLY_7= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:301:3: ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_TERMINOLOGY_GRAPH_TOKEN_1= RULE_TERMINOLOGY_GRAPH_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* this_RCURLY_7= RULE_RCURLY
            {
            // InternalOntologicalModelingLanguage.g:301:3: ( (lv_kind_0_0= ruleTerminologyGraphKind ) )
            // InternalOntologicalModelingLanguage.g:302:4: (lv_kind_0_0= ruleTerminologyGraphKind )
            {
            // InternalOntologicalModelingLanguage.g:302:4: (lv_kind_0_0= ruleTerminologyGraphKind )
            // InternalOntologicalModelingLanguage.g:303:5: lv_kind_0_0= ruleTerminologyGraphKind
            {

            					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getKindTerminologyGraphKindEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
            lv_kind_0_0=ruleTerminologyGraphKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_0_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.TerminologyGraphKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_TERMINOLOGY_GRAPH_TOKEN_1=(Token)match(input,RULE_TERMINOLOGY_GRAPH_TOKEN,FOLLOW_7); 

            			newLeafNode(this_TERMINOLOGY_GRAPH_TOKEN_1, grammarAccess.getTerminologyGraphAccess().getTERMINOLOGY_GRAPH_TOKENTerminalRuleCall_1());
            		
            // InternalOntologicalModelingLanguage.g:324:3: ( (lv_iri_2_0= RULE_IRI ) )
            // InternalOntologicalModelingLanguage.g:325:4: (lv_iri_2_0= RULE_IRI )
            {
            // InternalOntologicalModelingLanguage.g:325:4: (lv_iri_2_0= RULE_IRI )
            // InternalOntologicalModelingLanguage.g:326:5: lv_iri_2_0= RULE_IRI
            {
            lv_iri_2_0=(Token)match(input,RULE_IRI,FOLLOW_10); 

            					newLeafNode(lv_iri_2_0, grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyGraphRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_2_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.IRI");
            				

            }


            }

            this_LCURLY_3=(Token)match(input,RULE_LCURLY,FOLLOW_11); 

            			newLeafNode(this_LCURLY_3, grammarAccess.getTerminologyGraphAccess().getLCURLYTerminalRuleCall_3());
            		
            // InternalOntologicalModelingLanguage.g:346:3: ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case RULE_ANNOTATION_TOKEN:
                    {
                    alt4=1;
                    }
                    break;
                case RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN:
                case RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN:
                case RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN:
                    {
                    alt4=2;
                    }
                    break;
                case RULE_IRI:
                case RULE_ASPECT_TOKEN:
                case RULE_ID:
                case RULE_ABSTRACT_TOKEN:
                case RULE_CONCEPT_TOKEN:
                case RULE_REIFIED_RELATIONSHIP_TOKEN:
                case RULE_UNREIFIED_RELATIONSHIP_TOKEN:
                case RULE_SCALAR_TOKEN:
                case RULE_STRUCTURE_TOKEN:
                case RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN:
                case RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN:
                case RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN:
                case RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN:
                case RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN:
                case RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN:
                case RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN:
                case RULE_BINARY_SCALAR_RESTRICTION_TOKEN:
                case RULE_IRI_SCALAR_RESTRICTION_TOKEN:
                case RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN:
                case RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN:
                case RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN:
                case RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN:
                case RULE_STRING_SCALAR_RESTRICTION_TOKEN:
                case RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN:
                case RULE_TIME_SCALAR_RESTRICTION_TOKEN:
                case 73:
                case 74:
                case 75:
                case 76:
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // InternalOntologicalModelingLanguage.g:347:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    {
            	    // InternalOntologicalModelingLanguage.g:347:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    // InternalOntologicalModelingLanguage.g:348:5: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalOntologicalModelingLanguage.g:348:5: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalOntologicalModelingLanguage.g:349:6: lv_annotations_4_0= ruleAnnotation
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"annotations",
            	    							lv_annotations_4_0,
            	    							"jpl.imce.oml.specification.OntologicalModelingLanguage.Annotation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOntologicalModelingLanguage.g:367:4: ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOntologicalModelingLanguage.g:367:4: ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOntologicalModelingLanguage.g:368:5: (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOntologicalModelingLanguage.g:368:5: (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    // InternalOntologicalModelingLanguage.g:369:6: lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getTerminologyBoxAxiomsTerminologyBoxAxiomParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_terminologyBoxAxioms_5_0=ruleTerminologyBoxAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"terminologyBoxAxioms",
            	    							lv_terminologyBoxAxioms_5_0,
            	    							"jpl.imce.oml.specification.OntologicalModelingLanguage.TerminologyBoxAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOntologicalModelingLanguage.g:387:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOntologicalModelingLanguage.g:387:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    // InternalOntologicalModelingLanguage.g:388:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOntologicalModelingLanguage.g:388:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    // InternalOntologicalModelingLanguage.g:389:6: lv_boxStatements_6_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_4_2_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_boxStatements_6_0=ruleTerminologyBoxStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxStatements",
            	    							lv_boxStatements_6_0,
            	    							"jpl.imce.oml.specification.OntologicalModelingLanguage.TerminologyBoxStatement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            this_RCURLY_7=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_7, grammarAccess.getTerminologyGraphAccess().getRCURLYTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyGraph"


    // $ANTLR start "entryRuleBundle"
    // InternalOntologicalModelingLanguage.g:415:1: entryRuleBundle returns [EObject current=null] : iv_ruleBundle= ruleBundle EOF ;
    public final EObject entryRuleBundle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundle = null;


        try {
            // InternalOntologicalModelingLanguage.g:415:47: (iv_ruleBundle= ruleBundle EOF )
            // InternalOntologicalModelingLanguage.g:416:2: iv_ruleBundle= ruleBundle EOF
            {
             newCompositeNode(grammarAccess.getBundleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBundle=ruleBundle();

            state._fsp--;

             current =iv_ruleBundle; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBundle"


    // $ANTLR start "ruleBundle"
    // InternalOntologicalModelingLanguage.g:422:1: ruleBundle returns [EObject current=null] : ( ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_BUNDLE_TOKEN_1= RULE_BUNDLE_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* this_RCURLY_9= RULE_RCURLY ) ;
    public final EObject ruleBundle() throws RecognitionException {
        EObject current = null;

        Token this_BUNDLE_TOKEN_1=null;
        Token lv_iri_2_0=null;
        Token this_LCURLY_3=null;
        Token this_RCURLY_9=null;
        Enumerator lv_kind_0_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_terminologyBoxAxioms_5_0 = null;

        EObject lv_boxStatements_6_0 = null;

        EObject lv_bundleStatements_7_0 = null;

        EObject lv_terminologyBundleAxioms_8_0 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:428:2: ( ( ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_BUNDLE_TOKEN_1= RULE_BUNDLE_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* this_RCURLY_9= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:429:2: ( ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_BUNDLE_TOKEN_1= RULE_BUNDLE_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* this_RCURLY_9= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:429:2: ( ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_BUNDLE_TOKEN_1= RULE_BUNDLE_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* this_RCURLY_9= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:430:3: ( (lv_kind_0_0= ruleTerminologyGraphKind ) ) this_BUNDLE_TOKEN_1= RULE_BUNDLE_TOKEN ( (lv_iri_2_0= RULE_IRI ) ) this_LCURLY_3= RULE_LCURLY ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* this_RCURLY_9= RULE_RCURLY
            {
            // InternalOntologicalModelingLanguage.g:430:3: ( (lv_kind_0_0= ruleTerminologyGraphKind ) )
            // InternalOntologicalModelingLanguage.g:431:4: (lv_kind_0_0= ruleTerminologyGraphKind )
            {
            // InternalOntologicalModelingLanguage.g:431:4: (lv_kind_0_0= ruleTerminologyGraphKind )
            // InternalOntologicalModelingLanguage.g:432:5: lv_kind_0_0= ruleTerminologyGraphKind
            {

            					newCompositeNode(grammarAccess.getBundleAccess().getKindTerminologyGraphKindEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_kind_0_0=ruleTerminologyGraphKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBundleRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_0_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.TerminologyGraphKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_BUNDLE_TOKEN_1=(Token)match(input,RULE_BUNDLE_TOKEN,FOLLOW_7); 

            			newLeafNode(this_BUNDLE_TOKEN_1, grammarAccess.getBundleAccess().getBUNDLE_TOKENTerminalRuleCall_1());
            		
            // InternalOntologicalModelingLanguage.g:453:3: ( (lv_iri_2_0= RULE_IRI ) )
            // InternalOntologicalModelingLanguage.g:454:4: (lv_iri_2_0= RULE_IRI )
            {
            // InternalOntologicalModelingLanguage.g:454:4: (lv_iri_2_0= RULE_IRI )
            // InternalOntologicalModelingLanguage.g:455:5: lv_iri_2_0= RULE_IRI
            {
            lv_iri_2_0=(Token)match(input,RULE_IRI,FOLLOW_10); 

            					newLeafNode(lv_iri_2_0, grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBundleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_2_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.IRI");
            				

            }


            }

            this_LCURLY_3=(Token)match(input,RULE_LCURLY,FOLLOW_13); 

            			newLeafNode(this_LCURLY_3, grammarAccess.getBundleAccess().getLCURLYTerminalRuleCall_3());
            		
            // InternalOntologicalModelingLanguage.g:475:3: ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )*
            loop5:
            do {
                int alt5=6;
                switch ( input.LA(1) ) {
                case RULE_ANNOTATION_TOKEN:
                    {
                    alt5=1;
                    }
                    break;
                case RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN:
                case RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN:
                case RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN:
                    {
                    alt5=2;
                    }
                    break;
                case RULE_IRI:
                case RULE_ASPECT_TOKEN:
                case RULE_ID:
                case RULE_ABSTRACT_TOKEN:
                case RULE_CONCEPT_TOKEN:
                case RULE_REIFIED_RELATIONSHIP_TOKEN:
                case RULE_UNREIFIED_RELATIONSHIP_TOKEN:
                case RULE_SCALAR_TOKEN:
                case RULE_STRUCTURE_TOKEN:
                case RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN:
                case RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN:
                case RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN:
                case RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN:
                case RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN:
                case RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN:
                case RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN:
                case RULE_BINARY_SCALAR_RESTRICTION_TOKEN:
                case RULE_IRI_SCALAR_RESTRICTION_TOKEN:
                case RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN:
                case RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN:
                case RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN:
                case RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN:
                case RULE_STRING_SCALAR_RESTRICTION_TOKEN:
                case RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN:
                case RULE_TIME_SCALAR_RESTRICTION_TOKEN:
                case 73:
                case 74:
                case 75:
                case 76:
                    {
                    alt5=3;
                    }
                    break;
                case RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN:
                case RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN:
                case RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN:
                    {
                    alt5=4;
                    }
                    break;
                case RULE_BUNDLED_TERMINOLOGY_AXIOM_TOKEN:
                    {
                    alt5=5;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // InternalOntologicalModelingLanguage.g:476:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    {
            	    // InternalOntologicalModelingLanguage.g:476:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    // InternalOntologicalModelingLanguage.g:477:5: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalOntologicalModelingLanguage.g:477:5: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalOntologicalModelingLanguage.g:478:6: lv_annotations_4_0= ruleAnnotation
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getAnnotationsAnnotationParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"annotations",
            	    							lv_annotations_4_0,
            	    							"jpl.imce.oml.specification.OntologicalModelingLanguage.Annotation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOntologicalModelingLanguage.g:496:4: ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOntologicalModelingLanguage.g:496:4: ( (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOntologicalModelingLanguage.g:497:5: (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOntologicalModelingLanguage.g:497:5: (lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    // InternalOntologicalModelingLanguage.g:498:6: lv_terminologyBoxAxioms_5_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getTerminologyBoxAxiomsTerminologyBoxAxiomParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_terminologyBoxAxioms_5_0=ruleTerminologyBoxAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"terminologyBoxAxioms",
            	    							lv_terminologyBoxAxioms_5_0,
            	    							"jpl.imce.oml.specification.OntologicalModelingLanguage.TerminologyBoxAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOntologicalModelingLanguage.g:516:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOntologicalModelingLanguage.g:516:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    // InternalOntologicalModelingLanguage.g:517:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOntologicalModelingLanguage.g:517:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    // InternalOntologicalModelingLanguage.g:518:6: lv_boxStatements_6_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_4_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_boxStatements_6_0=ruleTerminologyBoxStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxStatements",
            	    							lv_boxStatements_6_0,
            	    							"jpl.imce.oml.specification.OntologicalModelingLanguage.TerminologyBoxStatement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOntologicalModelingLanguage.g:536:4: ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) )
            	    {
            	    // InternalOntologicalModelingLanguage.g:536:4: ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) )
            	    // InternalOntologicalModelingLanguage.g:537:5: (lv_bundleStatements_7_0= ruleTerminologyBundleStatement )
            	    {
            	    // InternalOntologicalModelingLanguage.g:537:5: (lv_bundleStatements_7_0= ruleTerminologyBundleStatement )
            	    // InternalOntologicalModelingLanguage.g:538:6: lv_bundleStatements_7_0= ruleTerminologyBundleStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_4_3_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_bundleStatements_7_0=ruleTerminologyBundleStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"bundleStatements",
            	    							lv_bundleStatements_7_0,
            	    							"jpl.imce.oml.specification.OntologicalModelingLanguage.TerminologyBundleStatement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalOntologicalModelingLanguage.g:556:4: ( (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom ) )
            	    {
            	    // InternalOntologicalModelingLanguage.g:556:4: ( (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom ) )
            	    // InternalOntologicalModelingLanguage.g:557:5: (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom )
            	    {
            	    // InternalOntologicalModelingLanguage.g:557:5: (lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom )
            	    // InternalOntologicalModelingLanguage.g:558:6: lv_terminologyBundleAxioms_8_0= ruleTerminologyBundleAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getTerminologyBundleAxiomsTerminologyBundleAxiomParserRuleCall_4_4_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_terminologyBundleAxioms_8_0=ruleTerminologyBundleAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"terminologyBundleAxioms",
            	    							lv_terminologyBundleAxioms_8_0,
            	    							"jpl.imce.oml.specification.OntologicalModelingLanguage.TerminologyBundleAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            this_RCURLY_9=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_9, grammarAccess.getBundleAccess().getRCURLYTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBundle"


    // $ANTLR start "entryRuleTerminologyBoxAxiom"
    // InternalOntologicalModelingLanguage.g:584:1: entryRuleTerminologyBoxAxiom returns [EObject current=null] : iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF ;
    public final EObject entryRuleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:584:60: (iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF )
            // InternalOntologicalModelingLanguage.g:585:2: iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF
            {
             newCompositeNode(grammarAccess.getTerminologyBoxAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyBoxAxiom=ruleTerminologyBoxAxiom();

            state._fsp--;

             current =iv_ruleTerminologyBoxAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyBoxAxiom"


    // $ANTLR start "ruleTerminologyBoxAxiom"
    // InternalOntologicalModelingLanguage.g:591:1: ruleTerminologyBoxAxiom returns [EObject current=null] : (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) ;
    public final EObject ruleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptDesignationTerminologyAxiom_0 = null;

        EObject this_TerminologyExtensionAxiom_1 = null;

        EObject this_TerminologyNestingAxiom_2 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:597:2: ( (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) )
            // InternalOntologicalModelingLanguage.g:598:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            {
            // InternalOntologicalModelingLanguage.g:598:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN:
                {
                alt6=1;
                }
                break;
            case RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN:
                {
                alt6=2;
                }
                break;
            case RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:599:3: this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxAxiomAccess().getConceptDesignationTerminologyAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConceptDesignationTerminologyAxiom_0=ruleConceptDesignationTerminologyAxiom();

                    state._fsp--;


                    			current = this_ConceptDesignationTerminologyAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:608:3: this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyExtensionAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TerminologyExtensionAxiom_1=ruleTerminologyExtensionAxiom();

                    state._fsp--;


                    			current = this_TerminologyExtensionAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOntologicalModelingLanguage.g:617:3: this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyNestingAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_TerminologyNestingAxiom_2=ruleTerminologyNestingAxiom();

                    state._fsp--;


                    			current = this_TerminologyNestingAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyBoxAxiom"


    // $ANTLR start "entryRuleTerminologyBoxStatement"
    // InternalOntologicalModelingLanguage.g:629:1: entryRuleTerminologyBoxStatement returns [EObject current=null] : iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF ;
    public final EObject entryRuleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxStatement = null;


        try {
            // InternalOntologicalModelingLanguage.g:629:64: (iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF )
            // InternalOntologicalModelingLanguage.g:630:2: iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF
            {
             newCompositeNode(grammarAccess.getTerminologyBoxStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyBoxStatement=ruleTerminologyBoxStatement();

            state._fsp--;

             current =iv_ruleTerminologyBoxStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyBoxStatement"


    // $ANTLR start "ruleTerminologyBoxStatement"
    // InternalOntologicalModelingLanguage.g:636:1: ruleTerminologyBoxStatement returns [EObject current=null] : (this_Axiom_0= ruleAxiom | this_Term_1= ruleTerm ) ;
    public final EObject ruleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Axiom_0 = null;

        EObject this_Term_1 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:642:2: ( (this_Axiom_0= ruleAxiom | this_Term_1= ruleTerm ) )
            // InternalOntologicalModelingLanguage.g:643:2: (this_Axiom_0= ruleAxiom | this_Term_1= ruleTerm )
            {
            // InternalOntologicalModelingLanguage.g:643:2: (this_Axiom_0= ruleAxiom | this_Term_1= ruleTerm )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_IRI||LA7_0==RULE_ID||(LA7_0>=RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN && LA7_0<=RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN)||(LA7_0>=RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN && LA7_0<=RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN)||LA7_0==RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ASPECT_TOKEN||(LA7_0>=RULE_ABSTRACT_TOKEN && LA7_0<=RULE_REIFIED_RELATIONSHIP_TOKEN)||(LA7_0>=RULE_UNREIFIED_RELATIONSHIP_TOKEN && LA7_0<=RULE_STRUCTURE_TOKEN)||LA7_0==RULE_BINARY_SCALAR_RESTRICTION_TOKEN||(LA7_0>=RULE_IRI_SCALAR_RESTRICTION_TOKEN && LA7_0<=RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN)||(LA7_0>=RULE_STRING_SCALAR_RESTRICTION_TOKEN && LA7_0<=RULE_TIME_SCALAR_RESTRICTION_TOKEN)||(LA7_0>=73 && LA7_0<=76)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:644:3: this_Axiom_0= ruleAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxStatementAccess().getAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Axiom_0=ruleAxiom();

                    state._fsp--;


                    			current = this_Axiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:653:3: this_Term_1= ruleTerm
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxStatementAccess().getTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Term_1=ruleTerm();

                    state._fsp--;


                    			current = this_Term_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyBoxStatement"


    // $ANTLR start "entryRuleTerm"
    // InternalOntologicalModelingLanguage.g:665:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalOntologicalModelingLanguage.g:665:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalOntologicalModelingLanguage.g:666:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalOntologicalModelingLanguage.g:672:1: ruleTerm returns [EObject current=null] : (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicEntity_0 = null;

        EObject this_EntityRelationship_1 = null;

        EObject this_Datatype_2 = null;

        EObject this_DataRelationship_3 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:678:2: ( (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship ) )
            // InternalOntologicalModelingLanguage.g:679:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship )
            {
            // InternalOntologicalModelingLanguage.g:679:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_ASPECT_TOKEN:
            case RULE_CONCEPT_TOKEN:
                {
                alt8=1;
                }
                break;
            case RULE_ABSTRACT_TOKEN:
                {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==RULE_CONCEPT_TOKEN) ) {
                    alt8=1;
                }
                else if ( (LA8_2==RULE_REIFIED_RELATIONSHIP_TOKEN) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REIFIED_RELATIONSHIP_TOKEN:
            case RULE_UNREIFIED_RELATIONSHIP_TOKEN:
                {
                alt8=2;
                }
                break;
            case RULE_SCALAR_TOKEN:
            case RULE_STRUCTURE_TOKEN:
            case RULE_BINARY_SCALAR_RESTRICTION_TOKEN:
            case RULE_IRI_SCALAR_RESTRICTION_TOKEN:
            case RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN:
            case RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN:
            case RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN:
            case RULE_STRING_SCALAR_RESTRICTION_TOKEN:
            case RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN:
            case RULE_TIME_SCALAR_RESTRICTION_TOKEN:
                {
                alt8=3;
                }
                break;
            case 73:
            case 74:
            case 75:
            case 76:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:680:3: this_AtomicEntity_0= ruleAtomicEntity
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getAtomicEntityParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AtomicEntity_0=ruleAtomicEntity();

                    state._fsp--;


                    			current = this_AtomicEntity_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:689:3: this_EntityRelationship_1= ruleEntityRelationship
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getEntityRelationshipParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityRelationship_1=ruleEntityRelationship();

                    state._fsp--;


                    			current = this_EntityRelationship_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOntologicalModelingLanguage.g:698:3: this_Datatype_2= ruleDatatype
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getDatatypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Datatype_2=ruleDatatype();

                    state._fsp--;


                    			current = this_Datatype_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOntologicalModelingLanguage.g:707:3: this_DataRelationship_3= ruleDataRelationship
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getDataRelationshipParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataRelationship_3=ruleDataRelationship();

                    state._fsp--;


                    			current = this_DataRelationship_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtomicEntity"
    // InternalOntologicalModelingLanguage.g:719:1: entryRuleAtomicEntity returns [EObject current=null] : iv_ruleAtomicEntity= ruleAtomicEntity EOF ;
    public final EObject entryRuleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicEntity = null;


        try {
            // InternalOntologicalModelingLanguage.g:719:53: (iv_ruleAtomicEntity= ruleAtomicEntity EOF )
            // InternalOntologicalModelingLanguage.g:720:2: iv_ruleAtomicEntity= ruleAtomicEntity EOF
            {
             newCompositeNode(grammarAccess.getAtomicEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomicEntity=ruleAtomicEntity();

            state._fsp--;

             current =iv_ruleAtomicEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicEntity"


    // $ANTLR start "ruleAtomicEntity"
    // InternalOntologicalModelingLanguage.g:726:1: ruleAtomicEntity returns [EObject current=null] : (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) ;
    public final EObject ruleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Aspect_0 = null;

        EObject this_Concept_1 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:732:2: ( (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) )
            // InternalOntologicalModelingLanguage.g:733:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            {
            // InternalOntologicalModelingLanguage.g:733:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ASPECT_TOKEN) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=RULE_ABSTRACT_TOKEN && LA9_0<=RULE_CONCEPT_TOKEN)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:734:3: this_Aspect_0= ruleAspect
                    {

                    			newCompositeNode(grammarAccess.getAtomicEntityAccess().getAspectParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Aspect_0=ruleAspect();

                    state._fsp--;


                    			current = this_Aspect_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:743:3: this_Concept_1= ruleConcept
                    {

                    			newCompositeNode(grammarAccess.getAtomicEntityAccess().getConceptParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Concept_1=ruleConcept();

                    state._fsp--;


                    			current = this_Concept_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicEntity"


    // $ANTLR start "entryRuleEntityRelationship"
    // InternalOntologicalModelingLanguage.g:755:1: entryRuleEntityRelationship returns [EObject current=null] : iv_ruleEntityRelationship= ruleEntityRelationship EOF ;
    public final EObject entryRuleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRelationship = null;


        try {
            // InternalOntologicalModelingLanguage.g:755:59: (iv_ruleEntityRelationship= ruleEntityRelationship EOF )
            // InternalOntologicalModelingLanguage.g:756:2: iv_ruleEntityRelationship= ruleEntityRelationship EOF
            {
             newCompositeNode(grammarAccess.getEntityRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityRelationship=ruleEntityRelationship();

            state._fsp--;

             current =iv_ruleEntityRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityRelationship"


    // $ANTLR start "ruleEntityRelationship"
    // InternalOntologicalModelingLanguage.g:762:1: ruleEntityRelationship returns [EObject current=null] : (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) ;
    public final EObject ruleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_ReifiedRelationship_0 = null;

        EObject this_UnreifiedRelationship_1 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:768:2: ( (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) )
            // InternalOntologicalModelingLanguage.g:769:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            {
            // InternalOntologicalModelingLanguage.g:769:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ABSTRACT_TOKEN||LA10_0==RULE_REIFIED_RELATIONSHIP_TOKEN) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_UNREIFIED_RELATIONSHIP_TOKEN) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:770:3: this_ReifiedRelationship_0= ruleReifiedRelationship
                    {

                    			newCompositeNode(grammarAccess.getEntityRelationshipAccess().getReifiedRelationshipParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReifiedRelationship_0=ruleReifiedRelationship();

                    state._fsp--;


                    			current = this_ReifiedRelationship_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:779:3: this_UnreifiedRelationship_1= ruleUnreifiedRelationship
                    {

                    			newCompositeNode(grammarAccess.getEntityRelationshipAccess().getUnreifiedRelationshipParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnreifiedRelationship_1=ruleUnreifiedRelationship();

                    state._fsp--;


                    			current = this_UnreifiedRelationship_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityRelationship"


    // $ANTLR start "entryRuleDatatype"
    // InternalOntologicalModelingLanguage.g:791:1: entryRuleDatatype returns [EObject current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final EObject entryRuleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatype = null;


        try {
            // InternalOntologicalModelingLanguage.g:791:49: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalOntologicalModelingLanguage.g:792:2: iv_ruleDatatype= ruleDatatype EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // InternalOntologicalModelingLanguage.g:798:1: ruleDatatype returns [EObject current=null] : (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) ;
    public final EObject ruleDatatype() throws RecognitionException {
        EObject current = null;

        EObject this_ScalarDataRange_0 = null;

        EObject this_Structure_1 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:804:2: ( (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) )
            // InternalOntologicalModelingLanguage.g:805:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            {
            // InternalOntologicalModelingLanguage.g:805:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_SCALAR_TOKEN||LA11_0==RULE_BINARY_SCALAR_RESTRICTION_TOKEN||(LA11_0>=RULE_IRI_SCALAR_RESTRICTION_TOKEN && LA11_0<=RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN)||(LA11_0>=RULE_STRING_SCALAR_RESTRICTION_TOKEN && LA11_0<=RULE_TIME_SCALAR_RESTRICTION_TOKEN)) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_STRUCTURE_TOKEN) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:806:3: this_ScalarDataRange_0= ruleScalarDataRange
                    {

                    			newCompositeNode(grammarAccess.getDatatypeAccess().getScalarDataRangeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScalarDataRange_0=ruleScalarDataRange();

                    state._fsp--;


                    			current = this_ScalarDataRange_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:815:3: this_Structure_1= ruleStructure
                    {

                    			newCompositeNode(grammarAccess.getDatatypeAccess().getStructureParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Structure_1=ruleStructure();

                    state._fsp--;


                    			current = this_Structure_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleScalarDataRange"
    // InternalOntologicalModelingLanguage.g:827:1: entryRuleScalarDataRange returns [EObject current=null] : iv_ruleScalarDataRange= ruleScalarDataRange EOF ;
    public final EObject entryRuleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataRange = null;


        try {
            // InternalOntologicalModelingLanguage.g:827:56: (iv_ruleScalarDataRange= ruleScalarDataRange EOF )
            // InternalOntologicalModelingLanguage.g:828:2: iv_ruleScalarDataRange= ruleScalarDataRange EOF
            {
             newCompositeNode(grammarAccess.getScalarDataRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarDataRange=ruleScalarDataRange();

            state._fsp--;

             current =iv_ruleScalarDataRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarDataRange"


    // $ANTLR start "ruleScalarDataRange"
    // InternalOntologicalModelingLanguage.g:834:1: ruleScalarDataRange returns [EObject current=null] : (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) ;
    public final EObject ruleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject this_Scalar_0 = null;

        EObject this_RestrictedDataRange_1 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:840:2: ( (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) )
            // InternalOntologicalModelingLanguage.g:841:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            {
            // InternalOntologicalModelingLanguage.g:841:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_SCALAR_TOKEN) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_BINARY_SCALAR_RESTRICTION_TOKEN||(LA12_0>=RULE_IRI_SCALAR_RESTRICTION_TOKEN && LA12_0<=RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN)||(LA12_0>=RULE_STRING_SCALAR_RESTRICTION_TOKEN && LA12_0<=RULE_TIME_SCALAR_RESTRICTION_TOKEN)) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:842:3: this_Scalar_0= ruleScalar
                    {

                    			newCompositeNode(grammarAccess.getScalarDataRangeAccess().getScalarParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Scalar_0=ruleScalar();

                    state._fsp--;


                    			current = this_Scalar_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:851:3: this_RestrictedDataRange_1= ruleRestrictedDataRange
                    {

                    			newCompositeNode(grammarAccess.getScalarDataRangeAccess().getRestrictedDataRangeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RestrictedDataRange_1=ruleRestrictedDataRange();

                    state._fsp--;


                    			current = this_RestrictedDataRange_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarDataRange"


    // $ANTLR start "entryRuleRestrictedDataRange"
    // InternalOntologicalModelingLanguage.g:863:1: entryRuleRestrictedDataRange returns [EObject current=null] : iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF ;
    public final EObject entryRuleRestrictedDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictedDataRange = null;


        try {
            // InternalOntologicalModelingLanguage.g:863:60: (iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF )
            // InternalOntologicalModelingLanguage.g:864:2: iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF
            {
             newCompositeNode(grammarAccess.getRestrictedDataRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRestrictedDataRange=ruleRestrictedDataRange();

            state._fsp--;

             current =iv_ruleRestrictedDataRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestrictedDataRange"


    // $ANTLR start "ruleRestrictedDataRange"
    // InternalOntologicalModelingLanguage.g:870:1: ruleRestrictedDataRange returns [EObject current=null] : (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) ;
    public final EObject ruleRestrictedDataRange() throws RecognitionException {
        EObject current = null;

        EObject this_BinaryScalarRestriction_0 = null;

        EObject this_IRIScalarRestriction_1 = null;

        EObject this_NumericScalarRestriction_2 = null;

        EObject this_PlainLiteralScalarRestriction_3 = null;

        EObject this_ScalarOneOfRestriction_4 = null;

        EObject this_StringScalarRestriction_5 = null;

        EObject this_SynonymScalarRestriction_6 = null;

        EObject this_TimeScalarRestriction_7 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:876:2: ( (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) )
            // InternalOntologicalModelingLanguage.g:877:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            {
            // InternalOntologicalModelingLanguage.g:877:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            int alt13=8;
            switch ( input.LA(1) ) {
            case RULE_BINARY_SCALAR_RESTRICTION_TOKEN:
                {
                alt13=1;
                }
                break;
            case RULE_IRI_SCALAR_RESTRICTION_TOKEN:
                {
                alt13=2;
                }
                break;
            case RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN:
                {
                alt13=3;
                }
                break;
            case RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN:
                {
                alt13=4;
                }
                break;
            case RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN:
                {
                alt13=5;
                }
                break;
            case RULE_STRING_SCALAR_RESTRICTION_TOKEN:
                {
                alt13=6;
                }
                break;
            case RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN:
                {
                alt13=7;
                }
                break;
            case RULE_TIME_SCALAR_RESTRICTION_TOKEN:
                {
                alt13=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:878:3: this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getBinaryScalarRestrictionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BinaryScalarRestriction_0=ruleBinaryScalarRestriction();

                    state._fsp--;


                    			current = this_BinaryScalarRestriction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:887:3: this_IRIScalarRestriction_1= ruleIRIScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getIRIScalarRestrictionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_IRIScalarRestriction_1=ruleIRIScalarRestriction();

                    state._fsp--;


                    			current = this_IRIScalarRestriction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOntologicalModelingLanguage.g:896:3: this_NumericScalarRestriction_2= ruleNumericScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getNumericScalarRestrictionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericScalarRestriction_2=ruleNumericScalarRestriction();

                    state._fsp--;


                    			current = this_NumericScalarRestriction_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOntologicalModelingLanguage.g:905:3: this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getPlainLiteralScalarRestrictionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PlainLiteralScalarRestriction_3=rulePlainLiteralScalarRestriction();

                    state._fsp--;


                    			current = this_PlainLiteralScalarRestriction_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalOntologicalModelingLanguage.g:914:3: this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getScalarOneOfRestrictionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScalarOneOfRestriction_4=ruleScalarOneOfRestriction();

                    state._fsp--;


                    			current = this_ScalarOneOfRestriction_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalOntologicalModelingLanguage.g:923:3: this_StringScalarRestriction_5= ruleStringScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getStringScalarRestrictionParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringScalarRestriction_5=ruleStringScalarRestriction();

                    state._fsp--;


                    			current = this_StringScalarRestriction_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalOntologicalModelingLanguage.g:932:3: this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getSynonymScalarRestrictionParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_SynonymScalarRestriction_6=ruleSynonymScalarRestriction();

                    state._fsp--;


                    			current = this_SynonymScalarRestriction_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalOntologicalModelingLanguage.g:941:3: this_TimeScalarRestriction_7= ruleTimeScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getTimeScalarRestrictionParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeScalarRestriction_7=ruleTimeScalarRestriction();

                    state._fsp--;


                    			current = this_TimeScalarRestriction_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestrictedDataRange"


    // $ANTLR start "entryRuleDataRelationship"
    // InternalOntologicalModelingLanguage.g:953:1: entryRuleDataRelationship returns [EObject current=null] : iv_ruleDataRelationship= ruleDataRelationship EOF ;
    public final EObject entryRuleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataRelationship = null;


        try {
            // InternalOntologicalModelingLanguage.g:953:57: (iv_ruleDataRelationship= ruleDataRelationship EOF )
            // InternalOntologicalModelingLanguage.g:954:2: iv_ruleDataRelationship= ruleDataRelationship EOF
            {
             newCompositeNode(grammarAccess.getDataRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataRelationship=ruleDataRelationship();

            state._fsp--;

             current =iv_ruleDataRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataRelationship"


    // $ANTLR start "ruleDataRelationship"
    // InternalOntologicalModelingLanguage.g:960:1: ruleDataRelationship returns [EObject current=null] : (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) ;
    public final EObject ruleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataProperty_0 = null;

        EObject this_EntityScalarDataProperty_1 = null;

        EObject this_StructuredDataProperty_2 = null;

        EObject this_ScalarDataProperty_3 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:966:2: ( (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) )
            // InternalOntologicalModelingLanguage.g:967:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            {
            // InternalOntologicalModelingLanguage.g:967:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt14=1;
                }
                break;
            case 74:
                {
                alt14=2;
                }
                break;
            case 75:
                {
                alt14=3;
                }
                break;
            case 76:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:968:3: this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty
                    {

                    			newCompositeNode(grammarAccess.getDataRelationshipAccess().getEntityStructuredDataPropertyParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityStructuredDataProperty_0=ruleEntityStructuredDataProperty();

                    state._fsp--;


                    			current = this_EntityStructuredDataProperty_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:977:3: this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty
                    {

                    			newCompositeNode(grammarAccess.getDataRelationshipAccess().getEntityScalarDataPropertyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataProperty_1=ruleEntityScalarDataProperty();

                    state._fsp--;


                    			current = this_EntityScalarDataProperty_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOntologicalModelingLanguage.g:986:3: this_StructuredDataProperty_2= ruleStructuredDataProperty
                    {

                    			newCompositeNode(grammarAccess.getDataRelationshipAccess().getStructuredDataPropertyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StructuredDataProperty_2=ruleStructuredDataProperty();

                    state._fsp--;


                    			current = this_StructuredDataProperty_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOntologicalModelingLanguage.g:995:3: this_ScalarDataProperty_3= ruleScalarDataProperty
                    {

                    			newCompositeNode(grammarAccess.getDataRelationshipAccess().getScalarDataPropertyParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScalarDataProperty_3=ruleScalarDataProperty();

                    state._fsp--;


                    			current = this_ScalarDataProperty_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataRelationship"


    // $ANTLR start "entryRuleAxiom"
    // InternalOntologicalModelingLanguage.g:1007:1: entryRuleAxiom returns [EObject current=null] : iv_ruleAxiom= ruleAxiom EOF ;
    public final EObject entryRuleAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:1007:46: (iv_ruleAxiom= ruleAxiom EOF )
            // InternalOntologicalModelingLanguage.g:1008:2: iv_ruleAxiom= ruleAxiom EOF
            {
             newCompositeNode(grammarAccess.getAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAxiom=ruleAxiom();

            state._fsp--;

             current =iv_ruleAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAxiom"


    // $ANTLR start "ruleAxiom"
    // InternalOntologicalModelingLanguage.g:1014:1: ruleAxiom returns [EObject current=null] : (this_ScalarOneOfLiteralAxiom_0= ruleScalarOneOfLiteralAxiom | this_TermAxiom_1= ruleTermAxiom ) ;
    public final EObject ruleAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ScalarOneOfLiteralAxiom_0 = null;

        EObject this_TermAxiom_1 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1020:2: ( (this_ScalarOneOfLiteralAxiom_0= ruleScalarOneOfLiteralAxiom | this_TermAxiom_1= ruleTermAxiom ) )
            // InternalOntologicalModelingLanguage.g:1021:2: (this_ScalarOneOfLiteralAxiom_0= ruleScalarOneOfLiteralAxiom | this_TermAxiom_1= ruleTermAxiom )
            {
            // InternalOntologicalModelingLanguage.g:1021:2: (this_ScalarOneOfLiteralAxiom_0= ruleScalarOneOfLiteralAxiom | this_TermAxiom_1= ruleTermAxiom )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_IRI||LA15_0==RULE_ID||(LA15_0>=RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN && LA15_0<=RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN)||(LA15_0>=RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN && LA15_0<=RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN)) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1022:3: this_ScalarOneOfLiteralAxiom_0= ruleScalarOneOfLiteralAxiom
                    {

                    			newCompositeNode(grammarAccess.getAxiomAccess().getScalarOneOfLiteralAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScalarOneOfLiteralAxiom_0=ruleScalarOneOfLiteralAxiom();

                    state._fsp--;


                    			current = this_ScalarOneOfLiteralAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:1031:3: this_TermAxiom_1= ruleTermAxiom
                    {

                    			newCompositeNode(grammarAccess.getAxiomAccess().getTermAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TermAxiom_1=ruleTermAxiom();

                    state._fsp--;


                    			current = this_TermAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAxiom"


    // $ANTLR start "entryRuleTermAxiom"
    // InternalOntologicalModelingLanguage.g:1043:1: entryRuleTermAxiom returns [EObject current=null] : iv_ruleTermAxiom= ruleTermAxiom EOF ;
    public final EObject entryRuleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTermAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:1043:50: (iv_ruleTermAxiom= ruleTermAxiom EOF )
            // InternalOntologicalModelingLanguage.g:1044:2: iv_ruleTermAxiom= ruleTermAxiom EOF
            {
             newCompositeNode(grammarAccess.getTermAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTermAxiom=ruleTermAxiom();

            state._fsp--;

             current =iv_ruleTermAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTermAxiom"


    // $ANTLR start "ruleTermAxiom"
    // InternalOntologicalModelingLanguage.g:1050:1: ruleTermAxiom returns [EObject current=null] : (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_SpecializationAxiom_2= ruleSpecializationAxiom ) ;
    public final EObject ruleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyRestrictionAxiom_1 = null;

        EObject this_SpecializationAxiom_2 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1056:2: ( (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_SpecializationAxiom_2= ruleSpecializationAxiom ) )
            // InternalOntologicalModelingLanguage.g:1057:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_SpecializationAxiom_2= ruleSpecializationAxiom )
            {
            // InternalOntologicalModelingLanguage.g:1057:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_SpecializationAxiom_2= ruleSpecializationAxiom )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN:
            case RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN:
                {
                alt16=1;
                }
                break;
            case RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN:
            case RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN:
            case RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN:
                {
                alt16=2;
                }
                break;
            case RULE_IRI:
            case RULE_ID:
            case RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN:
            case RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1058:3: this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getEntityRestrictionAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityRestrictionAxiom_0=ruleEntityRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityRestrictionAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:1067:3: this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getEntityScalarDataPropertyRestrictionAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataPropertyRestrictionAxiom_1=ruleEntityScalarDataPropertyRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityScalarDataPropertyRestrictionAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOntologicalModelingLanguage.g:1076:3: this_SpecializationAxiom_2= ruleSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getSpecializationAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecializationAxiom_2=ruleSpecializationAxiom();

                    state._fsp--;


                    			current = this_SpecializationAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTermAxiom"


    // $ANTLR start "entryRuleEntityRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:1088:1: entryRuleEntityRestrictionAxiom returns [EObject current=null] : iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF ;
    public final EObject entryRuleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRestrictionAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:1088:63: (iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF )
            // InternalOntologicalModelingLanguage.g:1089:2: iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityRestrictionAxiom=ruleEntityRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityRestrictionAxiom"


    // $ANTLR start "ruleEntityRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:1095:1: ruleEntityRestrictionAxiom returns [EObject current=null] : (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityExistentialRestrictionAxiom_0 = null;

        EObject this_EntityUniversalRestrictionAxiom_1 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1101:2: ( (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) )
            // InternalOntologicalModelingLanguage.g:1102:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            {
            // InternalOntologicalModelingLanguage.g:1102:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1103:3: this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityRestrictionAxiomAccess().getEntityExistentialRestrictionAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityExistentialRestrictionAxiom_0=ruleEntityExistentialRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityExistentialRestrictionAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:1112:3: this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityRestrictionAxiomAccess().getEntityUniversalRestrictionAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityUniversalRestrictionAxiom_1=ruleEntityUniversalRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityUniversalRestrictionAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityRestrictionAxiom"


    // $ANTLR start "entryRuleEntityScalarDataPropertyRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:1124:1: entryRuleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyRestrictionAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:1124:81: (iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF )
            // InternalOntologicalModelingLanguage.g:1125:2: iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataPropertyRestrictionAxiom=ruleEntityScalarDataPropertyRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityScalarDataPropertyRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataPropertyRestrictionAxiom"


    // $ANTLR start "ruleEntityScalarDataPropertyRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:1131:1: ruleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityScalarDataPropertyExistentialRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyParticularRestrictionAxiom_1 = null;

        EObject this_EntityScalarDataPropertyUniversalRestrictionAxiom_2 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1137:2: ( (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) )
            // InternalOntologicalModelingLanguage.g:1138:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            {
            // InternalOntologicalModelingLanguage.g:1138:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN:
                {
                alt18=1;
                }
                break;
            case RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN:
                {
                alt18=2;
                }
                break;
            case RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1139:3: this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyExistentialRestrictionAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataPropertyExistentialRestrictionAxiom_0=ruleEntityScalarDataPropertyExistentialRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityScalarDataPropertyExistentialRestrictionAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:1148:3: this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyParticularRestrictionAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataPropertyParticularRestrictionAxiom_1=ruleEntityScalarDataPropertyParticularRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityScalarDataPropertyParticularRestrictionAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOntologicalModelingLanguage.g:1157:3: this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyUniversalRestrictionAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataPropertyUniversalRestrictionAxiom_2=ruleEntityScalarDataPropertyUniversalRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityScalarDataPropertyUniversalRestrictionAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataPropertyRestrictionAxiom"


    // $ANTLR start "entryRuleSpecializationAxiom"
    // InternalOntologicalModelingLanguage.g:1169:1: entryRuleSpecializationAxiom returns [EObject current=null] : iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF ;
    public final EObject entryRuleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecializationAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:1169:60: (iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF )
            // InternalOntologicalModelingLanguage.g:1170:2: iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF
            {
             newCompositeNode(grammarAccess.getSpecializationAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecializationAxiom=ruleSpecializationAxiom();

            state._fsp--;

             current =iv_ruleSpecializationAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecializationAxiom"


    // $ANTLR start "ruleSpecializationAxiom"
    // InternalOntologicalModelingLanguage.g:1176:1: ruleSpecializationAxiom returns [EObject current=null] : (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) ;
    public final EObject ruleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptSpecializationAxiom_0 = null;

        EObject this_AspectSpecializationAxiom_1 = null;

        EObject this_ReifiedRelationshipSpecializationAxiom_2 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1182:2: ( (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) )
            // InternalOntologicalModelingLanguage.g:1183:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            {
            // InternalOntologicalModelingLanguage.g:1183:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            int alt19=3;
            switch ( input.LA(1) ) {
            case RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN:
                {
                alt19=1;
                }
                break;
            case RULE_IRI:
            case RULE_ID:
                {
                alt19=2;
                }
                break;
            case RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1184:3: this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getSpecializationAxiomAccess().getConceptSpecializationAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConceptSpecializationAxiom_0=ruleConceptSpecializationAxiom();

                    state._fsp--;


                    			current = this_ConceptSpecializationAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:1193:3: this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getSpecializationAxiomAccess().getAspectSpecializationAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AspectSpecializationAxiom_1=ruleAspectSpecializationAxiom();

                    state._fsp--;


                    			current = this_AspectSpecializationAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOntologicalModelingLanguage.g:1202:3: this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getSpecializationAxiomAccess().getReifiedRelationshipSpecializationAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReifiedRelationshipSpecializationAxiom_2=ruleReifiedRelationshipSpecializationAxiom();

                    state._fsp--;


                    			current = this_ReifiedRelationshipSpecializationAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecializationAxiom"


    // $ANTLR start "entryRuleTerminologyBundleStatement"
    // InternalOntologicalModelingLanguage.g:1214:1: entryRuleTerminologyBundleStatement returns [EObject current=null] : iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF ;
    public final EObject entryRuleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleStatement = null;


        try {
            // InternalOntologicalModelingLanguage.g:1214:67: (iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF )
            // InternalOntologicalModelingLanguage.g:1215:2: iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF
            {
             newCompositeNode(grammarAccess.getTerminologyBundleStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyBundleStatement=ruleTerminologyBundleStatement();

            state._fsp--;

             current =iv_ruleTerminologyBundleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyBundleStatement"


    // $ANTLR start "ruleTerminologyBundleStatement"
    // InternalOntologicalModelingLanguage.g:1221:1: ruleTerminologyBundleStatement returns [EObject current=null] : (this_AnonymousConceptTaxonomyAxiom_0= ruleAnonymousConceptTaxonomyAxiom | this_RootConceptTaxonomyAxiom_1= ruleRootConceptTaxonomyAxiom | this_SpecificDisjointConceptAxiom_2= ruleSpecificDisjointConceptAxiom ) ;
    public final EObject ruleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_AnonymousConceptTaxonomyAxiom_0 = null;

        EObject this_RootConceptTaxonomyAxiom_1 = null;

        EObject this_SpecificDisjointConceptAxiom_2 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1227:2: ( (this_AnonymousConceptTaxonomyAxiom_0= ruleAnonymousConceptTaxonomyAxiom | this_RootConceptTaxonomyAxiom_1= ruleRootConceptTaxonomyAxiom | this_SpecificDisjointConceptAxiom_2= ruleSpecificDisjointConceptAxiom ) )
            // InternalOntologicalModelingLanguage.g:1228:2: (this_AnonymousConceptTaxonomyAxiom_0= ruleAnonymousConceptTaxonomyAxiom | this_RootConceptTaxonomyAxiom_1= ruleRootConceptTaxonomyAxiom | this_SpecificDisjointConceptAxiom_2= ruleSpecificDisjointConceptAxiom )
            {
            // InternalOntologicalModelingLanguage.g:1228:2: (this_AnonymousConceptTaxonomyAxiom_0= ruleAnonymousConceptTaxonomyAxiom | this_RootConceptTaxonomyAxiom_1= ruleRootConceptTaxonomyAxiom | this_SpecificDisjointConceptAxiom_2= ruleSpecificDisjointConceptAxiom )
            int alt20=3;
            switch ( input.LA(1) ) {
            case RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN:
                {
                alt20=1;
                }
                break;
            case RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN:
                {
                alt20=2;
                }
                break;
            case RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1229:3: this_AnonymousConceptTaxonomyAxiom_0= ruleAnonymousConceptTaxonomyAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBundleStatementAccess().getAnonymousConceptTaxonomyAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AnonymousConceptTaxonomyAxiom_0=ruleAnonymousConceptTaxonomyAxiom();

                    state._fsp--;


                    			current = this_AnonymousConceptTaxonomyAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:1238:3: this_RootConceptTaxonomyAxiom_1= ruleRootConceptTaxonomyAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBundleStatementAccess().getRootConceptTaxonomyAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RootConceptTaxonomyAxiom_1=ruleRootConceptTaxonomyAxiom();

                    state._fsp--;


                    			current = this_RootConceptTaxonomyAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOntologicalModelingLanguage.g:1247:3: this_SpecificDisjointConceptAxiom_2= ruleSpecificDisjointConceptAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBundleStatementAccess().getSpecificDisjointConceptAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecificDisjointConceptAxiom_2=ruleSpecificDisjointConceptAxiom();

                    state._fsp--;


                    			current = this_SpecificDisjointConceptAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyBundleStatement"


    // $ANTLR start "entryRuleTerminologyBundleAxiom"
    // InternalOntologicalModelingLanguage.g:1259:1: entryRuleTerminologyBundleAxiom returns [EObject current=null] : iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF ;
    public final EObject entryRuleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:1259:63: (iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF )
            // InternalOntologicalModelingLanguage.g:1260:2: iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF
            {
             newCompositeNode(grammarAccess.getTerminologyBundleAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyBundleAxiom=ruleTerminologyBundleAxiom();

            state._fsp--;

             current =iv_ruleTerminologyBundleAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyBundleAxiom"


    // $ANTLR start "ruleTerminologyBundleAxiom"
    // InternalOntologicalModelingLanguage.g:1266:1: ruleTerminologyBundleAxiom returns [EObject current=null] : this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom ;
    public final EObject ruleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_BundledTerminologyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1272:2: (this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom )
            // InternalOntologicalModelingLanguage.g:1273:2: this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom
            {

            		newCompositeNode(grammarAccess.getTerminologyBundleAxiomAccess().getBundledTerminologyAxiomParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_BundledTerminologyAxiom_0=ruleBundledTerminologyAxiom();

            state._fsp--;


            		current = this_BundledTerminologyAxiom_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyBundleAxiom"


    // $ANTLR start "entryRuleAspect"
    // InternalOntologicalModelingLanguage.g:1284:1: entryRuleAspect returns [EObject current=null] : iv_ruleAspect= ruleAspect EOF ;
    public final EObject entryRuleAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspect = null;


        try {
            // InternalOntologicalModelingLanguage.g:1284:47: (iv_ruleAspect= ruleAspect EOF )
            // InternalOntologicalModelingLanguage.g:1285:2: iv_ruleAspect= ruleAspect EOF
            {
             newCompositeNode(grammarAccess.getAspectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAspect=ruleAspect();

            state._fsp--;

             current =iv_ruleAspect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAspect"


    // $ANTLR start "ruleAspect"
    // InternalOntologicalModelingLanguage.g:1291:1: ruleAspect returns [EObject current=null] : (this_ASPECT_TOKEN_0= RULE_ASPECT_TOKEN ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAspect() throws RecognitionException {
        EObject current = null;

        Token this_ASPECT_TOKEN_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1297:2: ( (this_ASPECT_TOKEN_0= RULE_ASPECT_TOKEN ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOntologicalModelingLanguage.g:1298:2: (this_ASPECT_TOKEN_0= RULE_ASPECT_TOKEN ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOntologicalModelingLanguage.g:1298:2: (this_ASPECT_TOKEN_0= RULE_ASPECT_TOKEN ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOntologicalModelingLanguage.g:1299:3: this_ASPECT_TOKEN_0= RULE_ASPECT_TOKEN ( (lv_name_1_0= RULE_ID ) )
            {
            this_ASPECT_TOKEN_0=(Token)match(input,RULE_ASPECT_TOKEN,FOLLOW_5); 

            			newLeafNode(this_ASPECT_TOKEN_0, grammarAccess.getAspectAccess().getASPECT_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:1303:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:1304:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:1304:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:1305:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAspect"


    // $ANTLR start "entryRuleConcept"
    // InternalOntologicalModelingLanguage.g:1325:1: entryRuleConcept returns [EObject current=null] : iv_ruleConcept= ruleConcept EOF ;
    public final EObject entryRuleConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcept = null;


        try {
            // InternalOntologicalModelingLanguage.g:1325:48: (iv_ruleConcept= ruleConcept EOF )
            // InternalOntologicalModelingLanguage.g:1326:2: iv_ruleConcept= ruleConcept EOF
            {
             newCompositeNode(grammarAccess.getConceptRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcept=ruleConcept();

            state._fsp--;

             current =iv_ruleConcept; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcept"


    // $ANTLR start "ruleConcept"
    // InternalOntologicalModelingLanguage.g:1332:1: ruleConcept returns [EObject current=null] : ( ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_CONCEPT_TOKEN_1= RULE_CONCEPT_TOKEN ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleConcept() throws RecognitionException {
        EObject current = null;

        Token lv_isAbstract_0_0=null;
        Token this_CONCEPT_TOKEN_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1338:2: ( ( ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_CONCEPT_TOKEN_1= RULE_CONCEPT_TOKEN ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOntologicalModelingLanguage.g:1339:2: ( ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_CONCEPT_TOKEN_1= RULE_CONCEPT_TOKEN ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOntologicalModelingLanguage.g:1339:2: ( ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_CONCEPT_TOKEN_1= RULE_CONCEPT_TOKEN ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOntologicalModelingLanguage.g:1340:3: ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_CONCEPT_TOKEN_1= RULE_CONCEPT_TOKEN ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOntologicalModelingLanguage.g:1340:3: ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ABSTRACT_TOKEN) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1341:4: (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1341:4: (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1342:5: lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN
                    {
                    lv_isAbstract_0_0=(Token)match(input,RULE_ABSTRACT_TOKEN,FOLLOW_14); 

                    					newLeafNode(lv_isAbstract_0_0, grammarAccess.getConceptAccess().getIsAbstractABSTRACT_TOKENTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getConceptRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isAbstract",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.ABSTRACT_TOKEN");
                    				

                    }


                    }
                    break;

            }

            this_CONCEPT_TOKEN_1=(Token)match(input,RULE_CONCEPT_TOKEN,FOLLOW_5); 

            			newLeafNode(this_CONCEPT_TOKEN_1, grammarAccess.getConceptAccess().getCONCEPT_TOKENTerminalRuleCall_1());
            		
            // InternalOntologicalModelingLanguage.g:1362:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:1363:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:1363:4: (lv_name_2_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:1364:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcept"


    // $ANTLR start "entryRuleReifiedRelationship"
    // InternalOntologicalModelingLanguage.g:1384:1: entryRuleReifiedRelationship returns [EObject current=null] : iv_ruleReifiedRelationship= ruleReifiedRelationship EOF ;
    public final EObject entryRuleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationship = null;


        try {
            // InternalOntologicalModelingLanguage.g:1384:60: (iv_ruleReifiedRelationship= ruleReifiedRelationship EOF )
            // InternalOntologicalModelingLanguage.g:1385:2: iv_ruleReifiedRelationship= ruleReifiedRelationship EOF
            {
             newCompositeNode(grammarAccess.getReifiedRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReifiedRelationship=ruleReifiedRelationship();

            state._fsp--;

             current =iv_ruleReifiedRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReifiedRelationship"


    // $ANTLR start "ruleReifiedRelationship"
    // InternalOntologicalModelingLanguage.g:1391:1: ruleReifiedRelationship returns [EObject current=null] : ( ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_REIFIED_RELATIONSHIP_TOKEN_1= RULE_REIFIED_RELATIONSHIP_TOKEN ( (lv_name_2_0= RULE_ID ) ) this_LCURLY_3= RULE_LCURLY ( (lv_isFunctional_4_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_5_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_6_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_7_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_8_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_9_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_10_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_11_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_12_0= RULE_TRANSITIVE_TOKEN ) )? this_UNREIFIED_TOKEN_13= RULE_UNREIFIED_TOKEN this_EQUAL_14= RULE_EQUAL ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (this_INVERSE_TOKEN_16= RULE_INVERSE_TOKEN this_EQUAL_17= RULE_EQUAL ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? this_SOURCE_TOKEN_19= RULE_SOURCE_TOKEN this_EQUAL_20= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_22= RULE_TARGET_TOKEN this_EQUAL_23= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_25= RULE_RCURLY ) ;
    public final EObject ruleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        Token lv_isAbstract_0_0=null;
        Token this_REIFIED_RELATIONSHIP_TOKEN_1=null;
        Token lv_name_2_0=null;
        Token this_LCURLY_3=null;
        Token lv_isFunctional_4_0=null;
        Token lv_isInverseFunctional_5_0=null;
        Token lv_isEssential_6_0=null;
        Token lv_isInverseEssential_7_0=null;
        Token lv_isSymmetric_8_0=null;
        Token lv_isAsymmetric_9_0=null;
        Token lv_isReflexive_10_0=null;
        Token lv_isIrreflexive_11_0=null;
        Token lv_isTransitive_12_0=null;
        Token this_UNREIFIED_TOKEN_13=null;
        Token this_EQUAL_14=null;
        Token lv_unreifiedPropertyName_15_0=null;
        Token this_INVERSE_TOKEN_16=null;
        Token this_EQUAL_17=null;
        Token lv_unreifiedInversePropertyName_18_0=null;
        Token this_SOURCE_TOKEN_19=null;
        Token this_EQUAL_20=null;
        Token this_TARGET_TOKEN_22=null;
        Token this_EQUAL_23=null;
        Token this_RCURLY_25=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1397:2: ( ( ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_REIFIED_RELATIONSHIP_TOKEN_1= RULE_REIFIED_RELATIONSHIP_TOKEN ( (lv_name_2_0= RULE_ID ) ) this_LCURLY_3= RULE_LCURLY ( (lv_isFunctional_4_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_5_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_6_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_7_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_8_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_9_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_10_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_11_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_12_0= RULE_TRANSITIVE_TOKEN ) )? this_UNREIFIED_TOKEN_13= RULE_UNREIFIED_TOKEN this_EQUAL_14= RULE_EQUAL ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (this_INVERSE_TOKEN_16= RULE_INVERSE_TOKEN this_EQUAL_17= RULE_EQUAL ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? this_SOURCE_TOKEN_19= RULE_SOURCE_TOKEN this_EQUAL_20= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_22= RULE_TARGET_TOKEN this_EQUAL_23= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_25= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:1398:2: ( ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_REIFIED_RELATIONSHIP_TOKEN_1= RULE_REIFIED_RELATIONSHIP_TOKEN ( (lv_name_2_0= RULE_ID ) ) this_LCURLY_3= RULE_LCURLY ( (lv_isFunctional_4_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_5_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_6_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_7_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_8_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_9_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_10_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_11_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_12_0= RULE_TRANSITIVE_TOKEN ) )? this_UNREIFIED_TOKEN_13= RULE_UNREIFIED_TOKEN this_EQUAL_14= RULE_EQUAL ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (this_INVERSE_TOKEN_16= RULE_INVERSE_TOKEN this_EQUAL_17= RULE_EQUAL ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? this_SOURCE_TOKEN_19= RULE_SOURCE_TOKEN this_EQUAL_20= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_22= RULE_TARGET_TOKEN this_EQUAL_23= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_25= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:1398:2: ( ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_REIFIED_RELATIONSHIP_TOKEN_1= RULE_REIFIED_RELATIONSHIP_TOKEN ( (lv_name_2_0= RULE_ID ) ) this_LCURLY_3= RULE_LCURLY ( (lv_isFunctional_4_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_5_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_6_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_7_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_8_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_9_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_10_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_11_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_12_0= RULE_TRANSITIVE_TOKEN ) )? this_UNREIFIED_TOKEN_13= RULE_UNREIFIED_TOKEN this_EQUAL_14= RULE_EQUAL ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (this_INVERSE_TOKEN_16= RULE_INVERSE_TOKEN this_EQUAL_17= RULE_EQUAL ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? this_SOURCE_TOKEN_19= RULE_SOURCE_TOKEN this_EQUAL_20= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_22= RULE_TARGET_TOKEN this_EQUAL_23= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_25= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:1399:3: ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )? this_REIFIED_RELATIONSHIP_TOKEN_1= RULE_REIFIED_RELATIONSHIP_TOKEN ( (lv_name_2_0= RULE_ID ) ) this_LCURLY_3= RULE_LCURLY ( (lv_isFunctional_4_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_5_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_6_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_7_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_8_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_9_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_10_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_11_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_12_0= RULE_TRANSITIVE_TOKEN ) )? this_UNREIFIED_TOKEN_13= RULE_UNREIFIED_TOKEN this_EQUAL_14= RULE_EQUAL ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (this_INVERSE_TOKEN_16= RULE_INVERSE_TOKEN this_EQUAL_17= RULE_EQUAL ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? this_SOURCE_TOKEN_19= RULE_SOURCE_TOKEN this_EQUAL_20= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_22= RULE_TARGET_TOKEN this_EQUAL_23= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_25= RULE_RCURLY
            {
            // InternalOntologicalModelingLanguage.g:1399:3: ( (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ABSTRACT_TOKEN) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1400:4: (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1400:4: (lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1401:5: lv_isAbstract_0_0= RULE_ABSTRACT_TOKEN
                    {
                    lv_isAbstract_0_0=(Token)match(input,RULE_ABSTRACT_TOKEN,FOLLOW_15); 

                    					newLeafNode(lv_isAbstract_0_0, grammarAccess.getReifiedRelationshipAccess().getIsAbstractABSTRACT_TOKENTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isAbstract",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.ABSTRACT_TOKEN");
                    				

                    }


                    }
                    break;

            }

            this_REIFIED_RELATIONSHIP_TOKEN_1=(Token)match(input,RULE_REIFIED_RELATIONSHIP_TOKEN,FOLLOW_5); 

            			newLeafNode(this_REIFIED_RELATIONSHIP_TOKEN_1, grammarAccess.getReifiedRelationshipAccess().getREIFIED_RELATIONSHIP_TOKENTerminalRuleCall_1());
            		
            // InternalOntologicalModelingLanguage.g:1421:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:1422:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:1422:4: (lv_name_2_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:1423:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_3=(Token)match(input,RULE_LCURLY,FOLLOW_16); 

            			newLeafNode(this_LCURLY_3, grammarAccess.getReifiedRelationshipAccess().getLCURLYTerminalRuleCall_3());
            		
            // InternalOntologicalModelingLanguage.g:1443:3: ( (lv_isFunctional_4_0= RULE_FUNCTIONAL_TOKEN ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_FUNCTIONAL_TOKEN) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1444:4: (lv_isFunctional_4_0= RULE_FUNCTIONAL_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1444:4: (lv_isFunctional_4_0= RULE_FUNCTIONAL_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1445:5: lv_isFunctional_4_0= RULE_FUNCTIONAL_TOKEN
                    {
                    lv_isFunctional_4_0=(Token)match(input,RULE_FUNCTIONAL_TOKEN,FOLLOW_17); 

                    					newLeafNode(lv_isFunctional_4_0, grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFUNCTIONAL_TOKENTerminalRuleCall_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isFunctional",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.FUNCTIONAL_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1461:3: ( (lv_isInverseFunctional_5_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_INVERSE_FUNCTIONAL_TOKEN) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1462:4: (lv_isInverseFunctional_5_0= RULE_INVERSE_FUNCTIONAL_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1462:4: (lv_isInverseFunctional_5_0= RULE_INVERSE_FUNCTIONAL_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1463:5: lv_isInverseFunctional_5_0= RULE_INVERSE_FUNCTIONAL_TOKEN
                    {
                    lv_isInverseFunctional_5_0=(Token)match(input,RULE_INVERSE_FUNCTIONAL_TOKEN,FOLLOW_18); 

                    					newLeafNode(lv_isInverseFunctional_5_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalINVERSE_FUNCTIONAL_TOKENTerminalRuleCall_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isInverseFunctional",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.INVERSE_FUNCTIONAL_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1479:3: ( (lv_isEssential_6_0= RULE_ESSENTIAL_TOKEN ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ESSENTIAL_TOKEN) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1480:4: (lv_isEssential_6_0= RULE_ESSENTIAL_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1480:4: (lv_isEssential_6_0= RULE_ESSENTIAL_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1481:5: lv_isEssential_6_0= RULE_ESSENTIAL_TOKEN
                    {
                    lv_isEssential_6_0=(Token)match(input,RULE_ESSENTIAL_TOKEN,FOLLOW_19); 

                    					newLeafNode(lv_isEssential_6_0, grammarAccess.getReifiedRelationshipAccess().getIsEssentialESSENTIAL_TOKENTerminalRuleCall_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isEssential",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.ESSENTIAL_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1497:3: ( (lv_isInverseEssential_7_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_INVERSE_ESSENTIAL_TOKEN) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1498:4: (lv_isInverseEssential_7_0= RULE_INVERSE_ESSENTIAL_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1498:4: (lv_isInverseEssential_7_0= RULE_INVERSE_ESSENTIAL_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1499:5: lv_isInverseEssential_7_0= RULE_INVERSE_ESSENTIAL_TOKEN
                    {
                    lv_isInverseEssential_7_0=(Token)match(input,RULE_INVERSE_ESSENTIAL_TOKEN,FOLLOW_20); 

                    					newLeafNode(lv_isInverseEssential_7_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialINVERSE_ESSENTIAL_TOKENTerminalRuleCall_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isInverseEssential",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.INVERSE_ESSENTIAL_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1515:3: ( (lv_isSymmetric_8_0= RULE_SYMMETRIC_TOKEN ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_SYMMETRIC_TOKEN) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1516:4: (lv_isSymmetric_8_0= RULE_SYMMETRIC_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1516:4: (lv_isSymmetric_8_0= RULE_SYMMETRIC_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1517:5: lv_isSymmetric_8_0= RULE_SYMMETRIC_TOKEN
                    {
                    lv_isSymmetric_8_0=(Token)match(input,RULE_SYMMETRIC_TOKEN,FOLLOW_21); 

                    					newLeafNode(lv_isSymmetric_8_0, grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSYMMETRIC_TOKENTerminalRuleCall_8_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isSymmetric",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.SYMMETRIC_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1533:3: ( (lv_isAsymmetric_9_0= RULE_ASYMMETRIC_TOKEN ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ASYMMETRIC_TOKEN) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1534:4: (lv_isAsymmetric_9_0= RULE_ASYMMETRIC_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1534:4: (lv_isAsymmetric_9_0= RULE_ASYMMETRIC_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1535:5: lv_isAsymmetric_9_0= RULE_ASYMMETRIC_TOKEN
                    {
                    lv_isAsymmetric_9_0=(Token)match(input,RULE_ASYMMETRIC_TOKEN,FOLLOW_22); 

                    					newLeafNode(lv_isAsymmetric_9_0, grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricASYMMETRIC_TOKENTerminalRuleCall_9_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isAsymmetric",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.ASYMMETRIC_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1551:3: ( (lv_isReflexive_10_0= RULE_REFLEXIVE_TOKEN ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_REFLEXIVE_TOKEN) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1552:4: (lv_isReflexive_10_0= RULE_REFLEXIVE_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1552:4: (lv_isReflexive_10_0= RULE_REFLEXIVE_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1553:5: lv_isReflexive_10_0= RULE_REFLEXIVE_TOKEN
                    {
                    lv_isReflexive_10_0=(Token)match(input,RULE_REFLEXIVE_TOKEN,FOLLOW_23); 

                    					newLeafNode(lv_isReflexive_10_0, grammarAccess.getReifiedRelationshipAccess().getIsReflexiveREFLEXIVE_TOKENTerminalRuleCall_10_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isReflexive",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.REFLEXIVE_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1569:3: ( (lv_isIrreflexive_11_0= RULE_IRREFLEXIVE_TOKEN ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_IRREFLEXIVE_TOKEN) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1570:4: (lv_isIrreflexive_11_0= RULE_IRREFLEXIVE_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1570:4: (lv_isIrreflexive_11_0= RULE_IRREFLEXIVE_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1571:5: lv_isIrreflexive_11_0= RULE_IRREFLEXIVE_TOKEN
                    {
                    lv_isIrreflexive_11_0=(Token)match(input,RULE_IRREFLEXIVE_TOKEN,FOLLOW_24); 

                    					newLeafNode(lv_isIrreflexive_11_0, grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIRREFLEXIVE_TOKENTerminalRuleCall_11_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isIrreflexive",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.IRREFLEXIVE_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1587:3: ( (lv_isTransitive_12_0= RULE_TRANSITIVE_TOKEN ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_TRANSITIVE_TOKEN) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1588:4: (lv_isTransitive_12_0= RULE_TRANSITIVE_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1588:4: (lv_isTransitive_12_0= RULE_TRANSITIVE_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1589:5: lv_isTransitive_12_0= RULE_TRANSITIVE_TOKEN
                    {
                    lv_isTransitive_12_0=(Token)match(input,RULE_TRANSITIVE_TOKEN,FOLLOW_25); 

                    					newLeafNode(lv_isTransitive_12_0, grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTRANSITIVE_TOKENTerminalRuleCall_12_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isTransitive",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.TRANSITIVE_TOKEN");
                    				

                    }


                    }
                    break;

            }

            this_UNREIFIED_TOKEN_13=(Token)match(input,RULE_UNREIFIED_TOKEN,FOLLOW_6); 

            			newLeafNode(this_UNREIFIED_TOKEN_13, grammarAccess.getReifiedRelationshipAccess().getUNREIFIED_TOKENTerminalRuleCall_13());
            		
            this_EQUAL_14=(Token)match(input,RULE_EQUAL,FOLLOW_5); 

            			newLeafNode(this_EQUAL_14, grammarAccess.getReifiedRelationshipAccess().getEQUALTerminalRuleCall_14());
            		
            // InternalOntologicalModelingLanguage.g:1613:3: ( (lv_unreifiedPropertyName_15_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:1614:4: (lv_unreifiedPropertyName_15_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:1614:4: (lv_unreifiedPropertyName_15_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:1615:5: lv_unreifiedPropertyName_15_0= RULE_ID
            {
            lv_unreifiedPropertyName_15_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(lv_unreifiedPropertyName_15_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameIDTerminalRuleCall_15_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"unreifiedPropertyName",
            						lv_unreifiedPropertyName_15_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            // InternalOntologicalModelingLanguage.g:1631:3: (this_INVERSE_TOKEN_16= RULE_INVERSE_TOKEN this_EQUAL_17= RULE_EQUAL ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_INVERSE_TOKEN) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1632:4: this_INVERSE_TOKEN_16= RULE_INVERSE_TOKEN this_EQUAL_17= RULE_EQUAL ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) )
                    {
                    this_INVERSE_TOKEN_16=(Token)match(input,RULE_INVERSE_TOKEN,FOLLOW_6); 

                    				newLeafNode(this_INVERSE_TOKEN_16, grammarAccess.getReifiedRelationshipAccess().getINVERSE_TOKENTerminalRuleCall_16_0());
                    			
                    this_EQUAL_17=(Token)match(input,RULE_EQUAL,FOLLOW_5); 

                    				newLeafNode(this_EQUAL_17, grammarAccess.getReifiedRelationshipAccess().getEQUALTerminalRuleCall_16_1());
                    			
                    // InternalOntologicalModelingLanguage.g:1640:4: ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) )
                    // InternalOntologicalModelingLanguage.g:1641:5: (lv_unreifiedInversePropertyName_18_0= RULE_ID )
                    {
                    // InternalOntologicalModelingLanguage.g:1641:5: (lv_unreifiedInversePropertyName_18_0= RULE_ID )
                    // InternalOntologicalModelingLanguage.g:1642:6: lv_unreifiedInversePropertyName_18_0= RULE_ID
                    {
                    lv_unreifiedInversePropertyName_18_0=(Token)match(input,RULE_ID,FOLLOW_27); 

                    						newLeafNode(lv_unreifiedInversePropertyName_18_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameIDTerminalRuleCall_16_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"unreifiedInversePropertyName",
                    							lv_unreifiedInversePropertyName_18_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            this_SOURCE_TOKEN_19=(Token)match(input,RULE_SOURCE_TOKEN,FOLLOW_6); 

            			newLeafNode(this_SOURCE_TOKEN_19, grammarAccess.getReifiedRelationshipAccess().getSOURCE_TOKENTerminalRuleCall_17());
            		
            this_EQUAL_20=(Token)match(input,RULE_EQUAL,FOLLOW_28); 

            			newLeafNode(this_EQUAL_20, grammarAccess.getReifiedRelationshipAccess().getEQUALTerminalRuleCall_18());
            		
            // InternalOntologicalModelingLanguage.g:1667:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:1668:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:1668:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:1669:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_19_0());
            				
            pushFollow(FOLLOW_29);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_TARGET_TOKEN_22=(Token)match(input,RULE_TARGET_TOKEN,FOLLOW_6); 

            			newLeafNode(this_TARGET_TOKEN_22, grammarAccess.getReifiedRelationshipAccess().getTARGET_TOKENTerminalRuleCall_20());
            		
            this_EQUAL_23=(Token)match(input,RULE_EQUAL,FOLLOW_28); 

            			newLeafNode(this_EQUAL_23, grammarAccess.getReifiedRelationshipAccess().getEQUALTerminalRuleCall_21());
            		
            // InternalOntologicalModelingLanguage.g:1691:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:1692:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:1692:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:1693:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_22_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_25=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_25, grammarAccess.getReifiedRelationshipAccess().getRCURLYTerminalRuleCall_23());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReifiedRelationship"


    // $ANTLR start "entryRuleUnreifiedRelationship"
    // InternalOntologicalModelingLanguage.g:1715:1: entryRuleUnreifiedRelationship returns [EObject current=null] : iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF ;
    public final EObject entryRuleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationship = null;


        try {
            // InternalOntologicalModelingLanguage.g:1715:62: (iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF )
            // InternalOntologicalModelingLanguage.g:1716:2: iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF
            {
             newCompositeNode(grammarAccess.getUnreifiedRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnreifiedRelationship=ruleUnreifiedRelationship();

            state._fsp--;

             current =iv_ruleUnreifiedRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnreifiedRelationship"


    // $ANTLR start "ruleUnreifiedRelationship"
    // InternalOntologicalModelingLanguage.g:1722:1: ruleUnreifiedRelationship returns [EObject current=null] : (this_UNREIFIED_RELATIONSHIP_TOKEN_0= RULE_UNREIFIED_RELATIONSHIP_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY ( (lv_isFunctional_3_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_4_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_5_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_6_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_7_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_8_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_9_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_10_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_11_0= RULE_TRANSITIVE_TOKEN ) )? this_SOURCE_TOKEN_12= RULE_SOURCE_TOKEN this_EQUAL_13= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_15= RULE_TARGET_TOKEN this_EQUAL_16= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_18= RULE_RCURLY ) ;
    public final EObject ruleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        Token this_UNREIFIED_RELATIONSHIP_TOKEN_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token lv_isFunctional_3_0=null;
        Token lv_isInverseFunctional_4_0=null;
        Token lv_isEssential_5_0=null;
        Token lv_isInverseEssential_6_0=null;
        Token lv_isSymmetric_7_0=null;
        Token lv_isAsymmetric_8_0=null;
        Token lv_isReflexive_9_0=null;
        Token lv_isIrreflexive_10_0=null;
        Token lv_isTransitive_11_0=null;
        Token this_SOURCE_TOKEN_12=null;
        Token this_EQUAL_13=null;
        Token this_TARGET_TOKEN_15=null;
        Token this_EQUAL_16=null;
        Token this_RCURLY_18=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1728:2: ( (this_UNREIFIED_RELATIONSHIP_TOKEN_0= RULE_UNREIFIED_RELATIONSHIP_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY ( (lv_isFunctional_3_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_4_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_5_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_6_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_7_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_8_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_9_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_10_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_11_0= RULE_TRANSITIVE_TOKEN ) )? this_SOURCE_TOKEN_12= RULE_SOURCE_TOKEN this_EQUAL_13= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_15= RULE_TARGET_TOKEN this_EQUAL_16= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_18= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:1729:2: (this_UNREIFIED_RELATIONSHIP_TOKEN_0= RULE_UNREIFIED_RELATIONSHIP_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY ( (lv_isFunctional_3_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_4_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_5_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_6_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_7_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_8_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_9_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_10_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_11_0= RULE_TRANSITIVE_TOKEN ) )? this_SOURCE_TOKEN_12= RULE_SOURCE_TOKEN this_EQUAL_13= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_15= RULE_TARGET_TOKEN this_EQUAL_16= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_18= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:1729:2: (this_UNREIFIED_RELATIONSHIP_TOKEN_0= RULE_UNREIFIED_RELATIONSHIP_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY ( (lv_isFunctional_3_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_4_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_5_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_6_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_7_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_8_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_9_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_10_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_11_0= RULE_TRANSITIVE_TOKEN ) )? this_SOURCE_TOKEN_12= RULE_SOURCE_TOKEN this_EQUAL_13= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_15= RULE_TARGET_TOKEN this_EQUAL_16= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_18= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:1730:3: this_UNREIFIED_RELATIONSHIP_TOKEN_0= RULE_UNREIFIED_RELATIONSHIP_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY ( (lv_isFunctional_3_0= RULE_FUNCTIONAL_TOKEN ) )? ( (lv_isInverseFunctional_4_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )? ( (lv_isEssential_5_0= RULE_ESSENTIAL_TOKEN ) )? ( (lv_isInverseEssential_6_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )? ( (lv_isSymmetric_7_0= RULE_SYMMETRIC_TOKEN ) )? ( (lv_isAsymmetric_8_0= RULE_ASYMMETRIC_TOKEN ) )? ( (lv_isReflexive_9_0= RULE_REFLEXIVE_TOKEN ) )? ( (lv_isIrreflexive_10_0= RULE_IRREFLEXIVE_TOKEN ) )? ( (lv_isTransitive_11_0= RULE_TRANSITIVE_TOKEN ) )? this_SOURCE_TOKEN_12= RULE_SOURCE_TOKEN this_EQUAL_13= RULE_EQUAL ( ( ruleReference ) ) this_TARGET_TOKEN_15= RULE_TARGET_TOKEN this_EQUAL_16= RULE_EQUAL ( ( ruleReference ) ) this_RCURLY_18= RULE_RCURLY
            {
            this_UNREIFIED_RELATIONSHIP_TOKEN_0=(Token)match(input,RULE_UNREIFIED_RELATIONSHIP_TOKEN,FOLLOW_5); 

            			newLeafNode(this_UNREIFIED_RELATIONSHIP_TOKEN_0, grammarAccess.getUnreifiedRelationshipAccess().getUNREIFIED_RELATIONSHIP_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:1734:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:1735:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:1735:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:1736:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_31); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getUnreifiedRelationshipAccess().getLCURLYTerminalRuleCall_2());
            		
            // InternalOntologicalModelingLanguage.g:1756:3: ( (lv_isFunctional_3_0= RULE_FUNCTIONAL_TOKEN ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_FUNCTIONAL_TOKEN) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1757:4: (lv_isFunctional_3_0= RULE_FUNCTIONAL_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1757:4: (lv_isFunctional_3_0= RULE_FUNCTIONAL_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1758:5: lv_isFunctional_3_0= RULE_FUNCTIONAL_TOKEN
                    {
                    lv_isFunctional_3_0=(Token)match(input,RULE_FUNCTIONAL_TOKEN,FOLLOW_32); 

                    					newLeafNode(lv_isFunctional_3_0, grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFUNCTIONAL_TOKENTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isFunctional",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.FUNCTIONAL_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1774:3: ( (lv_isInverseFunctional_4_0= RULE_INVERSE_FUNCTIONAL_TOKEN ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_INVERSE_FUNCTIONAL_TOKEN) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1775:4: (lv_isInverseFunctional_4_0= RULE_INVERSE_FUNCTIONAL_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1775:4: (lv_isInverseFunctional_4_0= RULE_INVERSE_FUNCTIONAL_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1776:5: lv_isInverseFunctional_4_0= RULE_INVERSE_FUNCTIONAL_TOKEN
                    {
                    lv_isInverseFunctional_4_0=(Token)match(input,RULE_INVERSE_FUNCTIONAL_TOKEN,FOLLOW_33); 

                    					newLeafNode(lv_isInverseFunctional_4_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalINVERSE_FUNCTIONAL_TOKENTerminalRuleCall_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isInverseFunctional",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.INVERSE_FUNCTIONAL_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1792:3: ( (lv_isEssential_5_0= RULE_ESSENTIAL_TOKEN ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ESSENTIAL_TOKEN) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1793:4: (lv_isEssential_5_0= RULE_ESSENTIAL_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1793:4: (lv_isEssential_5_0= RULE_ESSENTIAL_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1794:5: lv_isEssential_5_0= RULE_ESSENTIAL_TOKEN
                    {
                    lv_isEssential_5_0=(Token)match(input,RULE_ESSENTIAL_TOKEN,FOLLOW_34); 

                    					newLeafNode(lv_isEssential_5_0, grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialESSENTIAL_TOKENTerminalRuleCall_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isEssential",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.ESSENTIAL_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1810:3: ( (lv_isInverseEssential_6_0= RULE_INVERSE_ESSENTIAL_TOKEN ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_INVERSE_ESSENTIAL_TOKEN) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1811:4: (lv_isInverseEssential_6_0= RULE_INVERSE_ESSENTIAL_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1811:4: (lv_isInverseEssential_6_0= RULE_INVERSE_ESSENTIAL_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1812:5: lv_isInverseEssential_6_0= RULE_INVERSE_ESSENTIAL_TOKEN
                    {
                    lv_isInverseEssential_6_0=(Token)match(input,RULE_INVERSE_ESSENTIAL_TOKEN,FOLLOW_35); 

                    					newLeafNode(lv_isInverseEssential_6_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialINVERSE_ESSENTIAL_TOKENTerminalRuleCall_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isInverseEssential",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.INVERSE_ESSENTIAL_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1828:3: ( (lv_isSymmetric_7_0= RULE_SYMMETRIC_TOKEN ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_SYMMETRIC_TOKEN) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1829:4: (lv_isSymmetric_7_0= RULE_SYMMETRIC_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1829:4: (lv_isSymmetric_7_0= RULE_SYMMETRIC_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1830:5: lv_isSymmetric_7_0= RULE_SYMMETRIC_TOKEN
                    {
                    lv_isSymmetric_7_0=(Token)match(input,RULE_SYMMETRIC_TOKEN,FOLLOW_36); 

                    					newLeafNode(lv_isSymmetric_7_0, grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSYMMETRIC_TOKENTerminalRuleCall_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isSymmetric",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.SYMMETRIC_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1846:3: ( (lv_isAsymmetric_8_0= RULE_ASYMMETRIC_TOKEN ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ASYMMETRIC_TOKEN) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1847:4: (lv_isAsymmetric_8_0= RULE_ASYMMETRIC_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1847:4: (lv_isAsymmetric_8_0= RULE_ASYMMETRIC_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1848:5: lv_isAsymmetric_8_0= RULE_ASYMMETRIC_TOKEN
                    {
                    lv_isAsymmetric_8_0=(Token)match(input,RULE_ASYMMETRIC_TOKEN,FOLLOW_37); 

                    					newLeafNode(lv_isAsymmetric_8_0, grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricASYMMETRIC_TOKENTerminalRuleCall_8_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isAsymmetric",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.ASYMMETRIC_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1864:3: ( (lv_isReflexive_9_0= RULE_REFLEXIVE_TOKEN ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_REFLEXIVE_TOKEN) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1865:4: (lv_isReflexive_9_0= RULE_REFLEXIVE_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1865:4: (lv_isReflexive_9_0= RULE_REFLEXIVE_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1866:5: lv_isReflexive_9_0= RULE_REFLEXIVE_TOKEN
                    {
                    lv_isReflexive_9_0=(Token)match(input,RULE_REFLEXIVE_TOKEN,FOLLOW_38); 

                    					newLeafNode(lv_isReflexive_9_0, grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveREFLEXIVE_TOKENTerminalRuleCall_9_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isReflexive",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.REFLEXIVE_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1882:3: ( (lv_isIrreflexive_10_0= RULE_IRREFLEXIVE_TOKEN ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_IRREFLEXIVE_TOKEN) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1883:4: (lv_isIrreflexive_10_0= RULE_IRREFLEXIVE_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1883:4: (lv_isIrreflexive_10_0= RULE_IRREFLEXIVE_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1884:5: lv_isIrreflexive_10_0= RULE_IRREFLEXIVE_TOKEN
                    {
                    lv_isIrreflexive_10_0=(Token)match(input,RULE_IRREFLEXIVE_TOKEN,FOLLOW_39); 

                    					newLeafNode(lv_isIrreflexive_10_0, grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIRREFLEXIVE_TOKENTerminalRuleCall_10_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isIrreflexive",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.IRREFLEXIVE_TOKEN");
                    				

                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:1900:3: ( (lv_isTransitive_11_0= RULE_TRANSITIVE_TOKEN ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_TRANSITIVE_TOKEN) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:1901:4: (lv_isTransitive_11_0= RULE_TRANSITIVE_TOKEN )
                    {
                    // InternalOntologicalModelingLanguage.g:1901:4: (lv_isTransitive_11_0= RULE_TRANSITIVE_TOKEN )
                    // InternalOntologicalModelingLanguage.g:1902:5: lv_isTransitive_11_0= RULE_TRANSITIVE_TOKEN
                    {
                    lv_isTransitive_11_0=(Token)match(input,RULE_TRANSITIVE_TOKEN,FOLLOW_27); 

                    					newLeafNode(lv_isTransitive_11_0, grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTRANSITIVE_TOKENTerminalRuleCall_11_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"isTransitive",
                    						true,
                    						"jpl.imce.oml.specification.OntologicalModelingLanguage.TRANSITIVE_TOKEN");
                    				

                    }


                    }
                    break;

            }

            this_SOURCE_TOKEN_12=(Token)match(input,RULE_SOURCE_TOKEN,FOLLOW_6); 

            			newLeafNode(this_SOURCE_TOKEN_12, grammarAccess.getUnreifiedRelationshipAccess().getSOURCE_TOKENTerminalRuleCall_12());
            		
            this_EQUAL_13=(Token)match(input,RULE_EQUAL,FOLLOW_28); 

            			newLeafNode(this_EQUAL_13, grammarAccess.getUnreifiedRelationshipAccess().getEQUALTerminalRuleCall_13());
            		
            // InternalOntologicalModelingLanguage.g:1926:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:1927:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:1927:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:1928:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_14_0());
            				
            pushFollow(FOLLOW_29);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_TARGET_TOKEN_15=(Token)match(input,RULE_TARGET_TOKEN,FOLLOW_6); 

            			newLeafNode(this_TARGET_TOKEN_15, grammarAccess.getUnreifiedRelationshipAccess().getTARGET_TOKENTerminalRuleCall_15());
            		
            this_EQUAL_16=(Token)match(input,RULE_EQUAL,FOLLOW_28); 

            			newLeafNode(this_EQUAL_16, grammarAccess.getUnreifiedRelationshipAccess().getEQUALTerminalRuleCall_16());
            		
            // InternalOntologicalModelingLanguage.g:1950:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:1951:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:1951:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:1952:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_17_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_18=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_18, grammarAccess.getUnreifiedRelationshipAccess().getRCURLYTerminalRuleCall_18());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnreifiedRelationship"


    // $ANTLR start "entryRuleScalar"
    // InternalOntologicalModelingLanguage.g:1974:1: entryRuleScalar returns [EObject current=null] : iv_ruleScalar= ruleScalar EOF ;
    public final EObject entryRuleScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalar = null;


        try {
            // InternalOntologicalModelingLanguage.g:1974:47: (iv_ruleScalar= ruleScalar EOF )
            // InternalOntologicalModelingLanguage.g:1975:2: iv_ruleScalar= ruleScalar EOF
            {
             newCompositeNode(grammarAccess.getScalarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalar=ruleScalar();

            state._fsp--;

             current =iv_ruleScalar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalar"


    // $ANTLR start "ruleScalar"
    // InternalOntologicalModelingLanguage.g:1981:1: ruleScalar returns [EObject current=null] : (this_SCALAR_TOKEN_0= RULE_SCALAR_TOKEN ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleScalar() throws RecognitionException {
        EObject current = null;

        Token this_SCALAR_TOKEN_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:1987:2: ( (this_SCALAR_TOKEN_0= RULE_SCALAR_TOKEN ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOntologicalModelingLanguage.g:1988:2: (this_SCALAR_TOKEN_0= RULE_SCALAR_TOKEN ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOntologicalModelingLanguage.g:1988:2: (this_SCALAR_TOKEN_0= RULE_SCALAR_TOKEN ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOntologicalModelingLanguage.g:1989:3: this_SCALAR_TOKEN_0= RULE_SCALAR_TOKEN ( (lv_name_1_0= RULE_ID ) )
            {
            this_SCALAR_TOKEN_0=(Token)match(input,RULE_SCALAR_TOKEN,FOLLOW_5); 

            			newLeafNode(this_SCALAR_TOKEN_0, grammarAccess.getScalarAccess().getSCALAR_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:1993:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:1994:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:1994:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:1995:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalar"


    // $ANTLR start "entryRuleStructure"
    // InternalOntologicalModelingLanguage.g:2015:1: entryRuleStructure returns [EObject current=null] : iv_ruleStructure= ruleStructure EOF ;
    public final EObject entryRuleStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructure = null;


        try {
            // InternalOntologicalModelingLanguage.g:2015:50: (iv_ruleStructure= ruleStructure EOF )
            // InternalOntologicalModelingLanguage.g:2016:2: iv_ruleStructure= ruleStructure EOF
            {
             newCompositeNode(grammarAccess.getStructureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStructure=ruleStructure();

            state._fsp--;

             current =iv_ruleStructure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructure"


    // $ANTLR start "ruleStructure"
    // InternalOntologicalModelingLanguage.g:2022:1: ruleStructure returns [EObject current=null] : (this_STRUCTURE_TOKEN_0= RULE_STRUCTURE_TOKEN ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleStructure() throws RecognitionException {
        EObject current = null;

        Token this_STRUCTURE_TOKEN_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2028:2: ( (this_STRUCTURE_TOKEN_0= RULE_STRUCTURE_TOKEN ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOntologicalModelingLanguage.g:2029:2: (this_STRUCTURE_TOKEN_0= RULE_STRUCTURE_TOKEN ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOntologicalModelingLanguage.g:2029:2: (this_STRUCTURE_TOKEN_0= RULE_STRUCTURE_TOKEN ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOntologicalModelingLanguage.g:2030:3: this_STRUCTURE_TOKEN_0= RULE_STRUCTURE_TOKEN ( (lv_name_1_0= RULE_ID ) )
            {
            this_STRUCTURE_TOKEN_0=(Token)match(input,RULE_STRUCTURE_TOKEN,FOLLOW_5); 

            			newLeafNode(this_STRUCTURE_TOKEN_0, grammarAccess.getStructureAccess().getSTRUCTURE_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:2034:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:2035:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:2035:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:2036:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructureRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructure"


    // $ANTLR start "entryRuleEntityStructuredDataProperty"
    // InternalOntologicalModelingLanguage.g:2056:1: entryRuleEntityStructuredDataProperty returns [EObject current=null] : iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF ;
    public final EObject entryRuleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataProperty = null;


        try {
            // InternalOntologicalModelingLanguage.g:2056:69: (iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF )
            // InternalOntologicalModelingLanguage.g:2057:2: iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF
            {
             newCompositeNode(grammarAccess.getEntityStructuredDataPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityStructuredDataProperty=ruleEntityStructuredDataProperty();

            state._fsp--;

             current =iv_ruleEntityStructuredDataProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityStructuredDataProperty"


    // $ANTLR start "ruleEntityStructuredDataProperty"
    // InternalOntologicalModelingLanguage.g:2063:1: ruleEntityStructuredDataProperty returns [EObject current=null] : (otherlv_0= 'entityStructuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY ) ;
    public final EObject ruleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token this_DOMAIN_TOKEN_3=null;
        Token this_RANGE_TOKEN_5=null;
        Token this_RCURLY_7=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2069:2: ( (otherlv_0= 'entityStructuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2070:2: (otherlv_0= 'entityStructuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2070:2: (otherlv_0= 'entityStructuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2071:3: otherlv_0= 'entityStructuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY
            {
            otherlv_0=(Token)match(input,73,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_0());
            		
            // InternalOntologicalModelingLanguage.g:2075:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:2076:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:2076:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:2077:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntityStructuredDataPropertyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_40); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getEntityStructuredDataPropertyAccess().getLCURLYTerminalRuleCall_2());
            		
            this_DOMAIN_TOKEN_3=(Token)match(input,RULE_DOMAIN_TOKEN,FOLLOW_28); 

            			newLeafNode(this_DOMAIN_TOKEN_3, grammarAccess.getEntityStructuredDataPropertyAccess().getDOMAIN_TOKENTerminalRuleCall_3());
            		
            // InternalOntologicalModelingLanguage.g:2101:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2102:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2102:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2103:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_4_0());
            				
            pushFollow(FOLLOW_41);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RANGE_TOKEN_5=(Token)match(input,RULE_RANGE_TOKEN,FOLLOW_28); 

            			newLeafNode(this_RANGE_TOKEN_5, grammarAccess.getEntityStructuredDataPropertyAccess().getRANGE_TOKENTerminalRuleCall_5());
            		
            // InternalOntologicalModelingLanguage.g:2121:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2122:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2122:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2123:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_6_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_7=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_7, grammarAccess.getEntityStructuredDataPropertyAccess().getRCURLYTerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityStructuredDataProperty"


    // $ANTLR start "entryRuleEntityScalarDataProperty"
    // InternalOntologicalModelingLanguage.g:2145:1: entryRuleEntityScalarDataProperty returns [EObject current=null] : iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF ;
    public final EObject entryRuleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataProperty = null;


        try {
            // InternalOntologicalModelingLanguage.g:2145:65: (iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF )
            // InternalOntologicalModelingLanguage.g:2146:2: iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataProperty=ruleEntityScalarDataProperty();

            state._fsp--;

             current =iv_ruleEntityScalarDataProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataProperty"


    // $ANTLR start "ruleEntityScalarDataProperty"
    // InternalOntologicalModelingLanguage.g:2152:1: ruleEntityScalarDataProperty returns [EObject current=null] : (otherlv_0= 'entityScalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY ) ;
    public final EObject ruleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token this_DOMAIN_TOKEN_3=null;
        Token this_RANGE_TOKEN_5=null;
        Token this_RCURLY_7=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2158:2: ( (otherlv_0= 'entityScalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2159:2: (otherlv_0= 'entityScalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2159:2: (otherlv_0= 'entityScalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2160:3: otherlv_0= 'entityScalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY
            {
            otherlv_0=(Token)match(input,74,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_0());
            		
            // InternalOntologicalModelingLanguage.g:2164:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:2165:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:2165:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:2166:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntityScalarDataPropertyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_40); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getEntityScalarDataPropertyAccess().getLCURLYTerminalRuleCall_2());
            		
            this_DOMAIN_TOKEN_3=(Token)match(input,RULE_DOMAIN_TOKEN,FOLLOW_28); 

            			newLeafNode(this_DOMAIN_TOKEN_3, grammarAccess.getEntityScalarDataPropertyAccess().getDOMAIN_TOKENTerminalRuleCall_3());
            		
            // InternalOntologicalModelingLanguage.g:2190:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2191:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2191:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2192:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_4_0());
            				
            pushFollow(FOLLOW_41);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RANGE_TOKEN_5=(Token)match(input,RULE_RANGE_TOKEN,FOLLOW_28); 

            			newLeafNode(this_RANGE_TOKEN_5, grammarAccess.getEntityScalarDataPropertyAccess().getRANGE_TOKENTerminalRuleCall_5());
            		
            // InternalOntologicalModelingLanguage.g:2210:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2211:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2211:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2212:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_7=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_7, grammarAccess.getEntityScalarDataPropertyAccess().getRCURLYTerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataProperty"


    // $ANTLR start "entryRuleStructuredDataProperty"
    // InternalOntologicalModelingLanguage.g:2234:1: entryRuleStructuredDataProperty returns [EObject current=null] : iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF ;
    public final EObject entryRuleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataProperty = null;


        try {
            // InternalOntologicalModelingLanguage.g:2234:63: (iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF )
            // InternalOntologicalModelingLanguage.g:2235:2: iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF
            {
             newCompositeNode(grammarAccess.getStructuredDataPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStructuredDataProperty=ruleStructuredDataProperty();

            state._fsp--;

             current =iv_ruleStructuredDataProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructuredDataProperty"


    // $ANTLR start "ruleStructuredDataProperty"
    // InternalOntologicalModelingLanguage.g:2241:1: ruleStructuredDataProperty returns [EObject current=null] : (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY ) ;
    public final EObject ruleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token this_DOMAIN_TOKEN_3=null;
        Token this_RANGE_TOKEN_5=null;
        Token this_RCURLY_7=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2247:2: ( (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2248:2: (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2248:2: (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2249:3: otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY
            {
            otherlv_0=(Token)match(input,75,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_0());
            		
            // InternalOntologicalModelingLanguage.g:2253:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:2254:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:2254:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:2255:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_40); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getStructuredDataPropertyAccess().getLCURLYTerminalRuleCall_2());
            		
            this_DOMAIN_TOKEN_3=(Token)match(input,RULE_DOMAIN_TOKEN,FOLLOW_28); 

            			newLeafNode(this_DOMAIN_TOKEN_3, grammarAccess.getStructuredDataPropertyAccess().getDOMAIN_TOKENTerminalRuleCall_3());
            		
            // InternalOntologicalModelingLanguage.g:2279:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2280:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2280:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2281:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_4_0());
            				
            pushFollow(FOLLOW_41);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RANGE_TOKEN_5=(Token)match(input,RULE_RANGE_TOKEN,FOLLOW_28); 

            			newLeafNode(this_RANGE_TOKEN_5, grammarAccess.getStructuredDataPropertyAccess().getRANGE_TOKENTerminalRuleCall_5());
            		
            // InternalOntologicalModelingLanguage.g:2299:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2300:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2300:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2301:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_6_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_7=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_7, grammarAccess.getStructuredDataPropertyAccess().getRCURLYTerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructuredDataProperty"


    // $ANTLR start "entryRuleScalarDataProperty"
    // InternalOntologicalModelingLanguage.g:2323:1: entryRuleScalarDataProperty returns [EObject current=null] : iv_ruleScalarDataProperty= ruleScalarDataProperty EOF ;
    public final EObject entryRuleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataProperty = null;


        try {
            // InternalOntologicalModelingLanguage.g:2323:59: (iv_ruleScalarDataProperty= ruleScalarDataProperty EOF )
            // InternalOntologicalModelingLanguage.g:2324:2: iv_ruleScalarDataProperty= ruleScalarDataProperty EOF
            {
             newCompositeNode(grammarAccess.getScalarDataPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarDataProperty=ruleScalarDataProperty();

            state._fsp--;

             current =iv_ruleScalarDataProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarDataProperty"


    // $ANTLR start "ruleScalarDataProperty"
    // InternalOntologicalModelingLanguage.g:2330:1: ruleScalarDataProperty returns [EObject current=null] : (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY ) ;
    public final EObject ruleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token this_DOMAIN_TOKEN_3=null;
        Token this_RANGE_TOKEN_5=null;
        Token this_RCURLY_7=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2336:2: ( (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2337:2: (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2337:2: (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2338:3: otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY this_DOMAIN_TOKEN_3= RULE_DOMAIN_TOKEN ( ( ruleReference ) ) this_RANGE_TOKEN_5= RULE_RANGE_TOKEN ( ( ruleReference ) ) this_RCURLY_7= RULE_RCURLY
            {
            otherlv_0=(Token)match(input,76,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_0());
            		
            // InternalOntologicalModelingLanguage.g:2342:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:2343:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:2343:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:2344:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_40); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getScalarDataPropertyAccess().getLCURLYTerminalRuleCall_2());
            		
            this_DOMAIN_TOKEN_3=(Token)match(input,RULE_DOMAIN_TOKEN,FOLLOW_28); 

            			newLeafNode(this_DOMAIN_TOKEN_3, grammarAccess.getScalarDataPropertyAccess().getDOMAIN_TOKENTerminalRuleCall_3());
            		
            // InternalOntologicalModelingLanguage.g:2368:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2369:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2369:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2370:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_4_0());
            				
            pushFollow(FOLLOW_41);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RANGE_TOKEN_5=(Token)match(input,RULE_RANGE_TOKEN,FOLLOW_28); 

            			newLeafNode(this_RANGE_TOKEN_5, grammarAccess.getScalarDataPropertyAccess().getRANGE_TOKENTerminalRuleCall_5());
            		
            // InternalOntologicalModelingLanguage.g:2388:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2389:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2389:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2390:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_7=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_7, grammarAccess.getScalarDataPropertyAccess().getRCURLYTerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarDataProperty"


    // $ANTLR start "entryRuleAnonymousConceptTaxonomyAxiom"
    // InternalOntologicalModelingLanguage.g:2412:1: entryRuleAnonymousConceptTaxonomyAxiom returns [EObject current=null] : iv_ruleAnonymousConceptTaxonomyAxiom= ruleAnonymousConceptTaxonomyAxiom EOF ;
    public final EObject entryRuleAnonymousConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnonymousConceptTaxonomyAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2412:70: (iv_ruleAnonymousConceptTaxonomyAxiom= ruleAnonymousConceptTaxonomyAxiom EOF )
            // InternalOntologicalModelingLanguage.g:2413:2: iv_ruleAnonymousConceptTaxonomyAxiom= ruleAnonymousConceptTaxonomyAxiom EOF
            {
             newCompositeNode(grammarAccess.getAnonymousConceptTaxonomyAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnonymousConceptTaxonomyAxiom=ruleAnonymousConceptTaxonomyAxiom();

            state._fsp--;

             current =iv_ruleAnonymousConceptTaxonomyAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnonymousConceptTaxonomyAxiom"


    // $ANTLR start "ruleAnonymousConceptTaxonomyAxiom"
    // InternalOntologicalModelingLanguage.g:2419:1: ruleAnonymousConceptTaxonomyAxiom returns [EObject current=null] : (this_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY ) ;
    public final EObject ruleAnonymousConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        Token this_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token this_RCURLY_4=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2425:2: ( (this_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2426:2: (this_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2426:2: (this_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2427:3: this_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY
            {
            this_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN_0=(Token)match(input,RULE_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_ANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKEN_0, grammarAccess.getAnonymousConceptTaxonomyAxiomAccess().getANONYMOUS_CONCEPT_TAXONOMY_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_42); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getAnonymousConceptTaxonomyAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,77,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getAnonymousConceptTaxonomyAxiomAccess().getDisjointTaxonomyParentKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:2439:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2440:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2440:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2441:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnonymousConceptTaxonomyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAnonymousConceptTaxonomyAxiomAccess().getDisjointTaxonomyParentConceptTreeDisjunctionCrossReference_3_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_4=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_4, grammarAccess.getAnonymousConceptTaxonomyAxiomAccess().getRCURLYTerminalRuleCall_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnonymousConceptTaxonomyAxiom"


    // $ANTLR start "entryRuleRootConceptTaxonomyAxiom"
    // InternalOntologicalModelingLanguage.g:2463:1: entryRuleRootConceptTaxonomyAxiom returns [EObject current=null] : iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF ;
    public final EObject entryRuleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootConceptTaxonomyAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2463:65: (iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF )
            // InternalOntologicalModelingLanguage.g:2464:2: iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF
            {
             newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRootConceptTaxonomyAxiom=ruleRootConceptTaxonomyAxiom();

            state._fsp--;

             current =iv_ruleRootConceptTaxonomyAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRootConceptTaxonomyAxiom"


    // $ANTLR start "ruleRootConceptTaxonomyAxiom"
    // InternalOntologicalModelingLanguage.g:2470:1: ruleRootConceptTaxonomyAxiom returns [EObject current=null] : (this_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'root' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY ) ;
    public final EObject ruleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        Token this_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token this_RCURLY_4=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2476:2: ( (this_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'root' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2477:2: (this_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'root' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2477:2: (this_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'root' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2478:3: this_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN_0= RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'root' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY
            {
            this_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN_0=(Token)match(input,RULE_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_ROOT_CONCEPT_TAXONOMY_AXIOM_TOKEN_0, grammarAccess.getRootConceptTaxonomyAxiomAccess().getROOT_CONCEPT_TAXONOMY_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_43); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,78,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:2490:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2491:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2491:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2492:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRootConceptTaxonomyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_3_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_4=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_4, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRCURLYTerminalRuleCall_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRootConceptTaxonomyAxiom"


    // $ANTLR start "entryRuleSpecificDisjointConceptAxiom"
    // InternalOntologicalModelingLanguage.g:2514:1: entryRuleSpecificDisjointConceptAxiom returns [EObject current=null] : iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF ;
    public final EObject entryRuleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDisjointConceptAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2514:69: (iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF )
            // InternalOntologicalModelingLanguage.g:2515:2: iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF
            {
             newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecificDisjointConceptAxiom=ruleSpecificDisjointConceptAxiom();

            state._fsp--;

             current =iv_ruleSpecificDisjointConceptAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificDisjointConceptAxiom"


    // $ANTLR start "ruleSpecificDisjointConceptAxiom"
    // InternalOntologicalModelingLanguage.g:2521:1: ruleSpecificDisjointConceptAxiom returns [EObject current=null] : (this_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN_0= RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) otherlv_4= 'disjointLeaf' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) ;
    public final EObject ruleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        Token this_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_RCURLY_6=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2527:2: ( (this_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN_0= RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) otherlv_4= 'disjointLeaf' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2528:2: (this_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN_0= RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) otherlv_4= 'disjointLeaf' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2528:2: (this_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN_0= RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) otherlv_4= 'disjointLeaf' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2529:3: this_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN_0= RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'disjointTaxonomyParent' ( ( ruleReference ) ) otherlv_4= 'disjointLeaf' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY
            {
            this_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN_0=(Token)match(input,RULE_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_SPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKEN_0, grammarAccess.getSpecificDisjointConceptAxiomAccess().getSPECIFIC_DISJOINT_CONCEPT_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_42); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getSpecificDisjointConceptAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,77,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointTaxonomyParentKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:2541:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2542:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2542:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2543:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificDisjointConceptAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointTaxonomyParentConceptTreeDisjunctionCrossReference_3_0());
            				
            pushFollow(FOLLOW_44);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,79,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:2561:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2562:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2562:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2563:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificDisjointConceptAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_6, grammarAccess.getSpecificDisjointConceptAxiomAccess().getRCURLYTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificDisjointConceptAxiom"


    // $ANTLR start "entryRuleBundledTerminologyAxiom"
    // InternalOntologicalModelingLanguage.g:2585:1: entryRuleBundledTerminologyAxiom returns [EObject current=null] : iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF ;
    public final EObject entryRuleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundledTerminologyAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2585:64: (iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF )
            // InternalOntologicalModelingLanguage.g:2586:2: iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF
            {
             newCompositeNode(grammarAccess.getBundledTerminologyAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBundledTerminologyAxiom=ruleBundledTerminologyAxiom();

            state._fsp--;

             current =iv_ruleBundledTerminologyAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBundledTerminologyAxiom"


    // $ANTLR start "ruleBundledTerminologyAxiom"
    // InternalOntologicalModelingLanguage.g:2592:1: ruleBundledTerminologyAxiom returns [EObject current=null] : (this_BUNDLED_TERMINOLOGY_AXIOM_TOKEN_0= RULE_BUNDLED_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'bundledTerminology' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY ) ;
    public final EObject ruleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        Token this_BUNDLED_TERMINOLOGY_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token this_RCURLY_4=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2598:2: ( (this_BUNDLED_TERMINOLOGY_AXIOM_TOKEN_0= RULE_BUNDLED_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'bundledTerminology' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2599:2: (this_BUNDLED_TERMINOLOGY_AXIOM_TOKEN_0= RULE_BUNDLED_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'bundledTerminology' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2599:2: (this_BUNDLED_TERMINOLOGY_AXIOM_TOKEN_0= RULE_BUNDLED_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'bundledTerminology' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2600:3: this_BUNDLED_TERMINOLOGY_AXIOM_TOKEN_0= RULE_BUNDLED_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'bundledTerminology' ( ( ruleReference ) ) this_RCURLY_4= RULE_RCURLY
            {
            this_BUNDLED_TERMINOLOGY_AXIOM_TOKEN_0=(Token)match(input,RULE_BUNDLED_TERMINOLOGY_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_BUNDLED_TERMINOLOGY_AXIOM_TOKEN_0, grammarAccess.getBundledTerminologyAxiomAccess().getBUNDLED_TERMINOLOGY_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_45); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getBundledTerminologyAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,80,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:2612:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2613:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2613:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2614:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBundledTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxCrossReference_3_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_4=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_4, grammarAccess.getBundledTerminologyAxiomAccess().getRCURLYTerminalRuleCall_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBundledTerminologyAxiom"


    // $ANTLR start "entryRuleConceptDesignationTerminologyAxiom"
    // InternalOntologicalModelingLanguage.g:2636:1: entryRuleConceptDesignationTerminologyAxiom returns [EObject current=null] : iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF ;
    public final EObject entryRuleConceptDesignationTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptDesignationTerminologyAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2636:75: (iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF )
            // InternalOntologicalModelingLanguage.g:2637:2: iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF
            {
             newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConceptDesignationTerminologyAxiom=ruleConceptDesignationTerminologyAxiom();

            state._fsp--;

             current =iv_ruleConceptDesignationTerminologyAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConceptDesignationTerminologyAxiom"


    // $ANTLR start "ruleConceptDesignationTerminologyAxiom"
    // InternalOntologicalModelingLanguage.g:2643:1: ruleConceptDesignationTerminologyAxiom returns [EObject current=null] : (this_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN_0= RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'designatedTerminology' ( ( ruleReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) ;
    public final EObject ruleConceptDesignationTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        Token this_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_RCURLY_6=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2649:2: ( (this_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN_0= RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'designatedTerminology' ( ( ruleReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2650:2: (this_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN_0= RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'designatedTerminology' ( ( ruleReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2650:2: (this_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN_0= RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'designatedTerminology' ( ( ruleReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2651:3: this_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN_0= RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'designatedTerminology' ( ( ruleReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY
            {
            this_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN_0=(Token)match(input,RULE_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKEN_0, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getCONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_46); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,81,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:2663:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2664:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2664:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2665:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_3_0());
            				
            pushFollow(FOLLOW_47);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,82,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:2683:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2684:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2684:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2685:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_6, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getRCURLYTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConceptDesignationTerminologyAxiom"


    // $ANTLR start "entryRuleTerminologyExtensionAxiom"
    // InternalOntologicalModelingLanguage.g:2707:1: entryRuleTerminologyExtensionAxiom returns [EObject current=null] : iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF ;
    public final EObject entryRuleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyExtensionAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2707:66: (iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF )
            // InternalOntologicalModelingLanguage.g:2708:2: iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF
            {
             newCompositeNode(grammarAccess.getTerminologyExtensionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyExtensionAxiom=ruleTerminologyExtensionAxiom();

            state._fsp--;

             current =iv_ruleTerminologyExtensionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyExtensionAxiom"


    // $ANTLR start "ruleTerminologyExtensionAxiom"
    // InternalOntologicalModelingLanguage.g:2714:1: ruleTerminologyExtensionAxiom returns [EObject current=null] : (this_TERMINOLOGY_EXTENSION_AXIOM_TOKEN_0= RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN ( ( ruleReference ) ) ) ;
    public final EObject ruleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        Token this_TERMINOLOGY_EXTENSION_AXIOM_TOKEN_0=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2720:2: ( (this_TERMINOLOGY_EXTENSION_AXIOM_TOKEN_0= RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN ( ( ruleReference ) ) ) )
            // InternalOntologicalModelingLanguage.g:2721:2: (this_TERMINOLOGY_EXTENSION_AXIOM_TOKEN_0= RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN ( ( ruleReference ) ) )
            {
            // InternalOntologicalModelingLanguage.g:2721:2: (this_TERMINOLOGY_EXTENSION_AXIOM_TOKEN_0= RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN ( ( ruleReference ) ) )
            // InternalOntologicalModelingLanguage.g:2722:3: this_TERMINOLOGY_EXTENSION_AXIOM_TOKEN_0= RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN ( ( ruleReference ) )
            {
            this_TERMINOLOGY_EXTENSION_AXIOM_TOKEN_0=(Token)match(input,RULE_TERMINOLOGY_EXTENSION_AXIOM_TOKEN,FOLLOW_28); 

            			newLeafNode(this_TERMINOLOGY_EXTENSION_AXIOM_TOKEN_0, grammarAccess.getTerminologyExtensionAxiomAccess().getTERMINOLOGY_EXTENSION_AXIOM_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:2726:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2727:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2727:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2728:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyExtensionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyExtensionAxiom"


    // $ANTLR start "entryRuleTerminologyNestingAxiom"
    // InternalOntologicalModelingLanguage.g:2746:1: entryRuleTerminologyNestingAxiom returns [EObject current=null] : iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF ;
    public final EObject entryRuleTerminologyNestingAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyNestingAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2746:64: (iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF )
            // InternalOntologicalModelingLanguage.g:2747:2: iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF
            {
             newCompositeNode(grammarAccess.getTerminologyNestingAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyNestingAxiom=ruleTerminologyNestingAxiom();

            state._fsp--;

             current =iv_ruleTerminologyNestingAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyNestingAxiom"


    // $ANTLR start "ruleTerminologyNestingAxiom"
    // InternalOntologicalModelingLanguage.g:2753:1: ruleTerminologyNestingAxiom returns [EObject current=null] : (this_TERMINOLOGY_NESTING_AXIOM_TOKEN_0= RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'nestingTerminology' ( ( ruleReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) ;
    public final EObject ruleTerminologyNestingAxiom() throws RecognitionException {
        EObject current = null;

        Token this_TERMINOLOGY_NESTING_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_RCURLY_6=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2759:2: ( (this_TERMINOLOGY_NESTING_AXIOM_TOKEN_0= RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'nestingTerminology' ( ( ruleReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2760:2: (this_TERMINOLOGY_NESTING_AXIOM_TOKEN_0= RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'nestingTerminology' ( ( ruleReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2760:2: (this_TERMINOLOGY_NESTING_AXIOM_TOKEN_0= RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'nestingTerminology' ( ( ruleReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2761:3: this_TERMINOLOGY_NESTING_AXIOM_TOKEN_0= RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'nestingTerminology' ( ( ruleReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY
            {
            this_TERMINOLOGY_NESTING_AXIOM_TOKEN_0=(Token)match(input,RULE_TERMINOLOGY_NESTING_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_TERMINOLOGY_NESTING_AXIOM_TOKEN_0, grammarAccess.getTerminologyNestingAxiomAccess().getTERMINOLOGY_NESTING_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_48); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getTerminologyNestingAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,83,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:2773:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2774:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2774:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2775:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_3_0());
            				
            pushFollow(FOLLOW_49);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,84,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:2793:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2794:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2794:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2795:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_6, grammarAccess.getTerminologyNestingAxiomAccess().getRCURLYTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyNestingAxiom"


    // $ANTLR start "entryRuleEntityExistentialRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:2817:1: entryRuleEntityExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityExistentialRestrictionAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2817:74: (iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF )
            // InternalOntologicalModelingLanguage.g:2818:2: iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityExistentialRestrictionAxiom=ruleEntityExistentialRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityExistentialRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityExistentialRestrictionAxiom"


    // $ANTLR start "ruleEntityExistentialRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:2824:1: ruleEntityExistentialRestrictionAxiom returns [EObject current=null] : (this_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY ) ;
    public final EObject ruleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token this_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_RCURLY_8=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2830:2: ( (this_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2831:2: (this_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2831:2: (this_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2832:3: this_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY
            {
            this_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0=(Token)match(input,RULE_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getENTITY_EXISTENTIAL_RESTRICTION_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_50); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,85,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:2844:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2845:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2845:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2846:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_51);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:2864:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2865:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2865:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2866:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0());
            				
            pushFollow(FOLLOW_52);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,87,FOLLOW_28); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainKeyword_6());
            		
            // InternalOntologicalModelingLanguage.g:2884:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2885:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2885:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2886:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_7_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_8, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRCURLYTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityExistentialRestrictionAxiom"


    // $ANTLR start "entryRuleEntityUniversalRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:2908:1: entryRuleEntityUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityUniversalRestrictionAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2908:72: (iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF )
            // InternalOntologicalModelingLanguage.g:2909:2: iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityUniversalRestrictionAxiom=ruleEntityUniversalRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityUniversalRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityUniversalRestrictionAxiom"


    // $ANTLR start "ruleEntityUniversalRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:2915:1: ruleEntityUniversalRestrictionAxiom returns [EObject current=null] : (this_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY ) ;
    public final EObject ruleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token this_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_RCURLY_8=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:2921:2: ( (this_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:2922:2: (this_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:2922:2: (this_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:2923:3: this_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedRelation' ( ( ruleReference ) ) otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= 'restrictedDomain' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY
            {
            this_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0=(Token)match(input,RULE_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_ENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getENTITY_UNIVERSAL_RESTRICTION_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_50); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,85,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:2935:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2936:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2936:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2937:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_51);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:2955:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2956:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2956:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2957:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0());
            				
            pushFollow(FOLLOW_52);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,87,FOLLOW_28); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainKeyword_6());
            		
            // InternalOntologicalModelingLanguage.g:2975:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:2976:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:2976:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:2977:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_7_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_8, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRCURLYTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityUniversalRestrictionAxiom"


    // $ANTLR start "entryRuleAspectSpecializationAxiom"
    // InternalOntologicalModelingLanguage.g:2999:1: entryRuleAspectSpecializationAxiom returns [EObject current=null] : iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF ;
    public final EObject entryRuleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspectSpecializationAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:2999:66: (iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF )
            // InternalOntologicalModelingLanguage.g:3000:2: iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF
            {
             newCompositeNode(grammarAccess.getAspectSpecializationAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAspectSpecializationAxiom=ruleAspectSpecializationAxiom();

            state._fsp--;

             current =iv_ruleAspectSpecializationAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAspectSpecializationAxiom"


    // $ANTLR start "ruleAspectSpecializationAxiom"
    // InternalOntologicalModelingLanguage.g:3006:1: ruleAspectSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) this_ASPECT_SPECIALIZATION_AXIOM_TOKEN_1= RULE_ASPECT_SPECIALIZATION_AXIOM_TOKEN ( ( ruleReference ) ) ) ;
    public final EObject ruleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token this_ASPECT_SPECIALIZATION_AXIOM_TOKEN_1=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3012:2: ( ( ( ( ruleReference ) ) this_ASPECT_SPECIALIZATION_AXIOM_TOKEN_1= RULE_ASPECT_SPECIALIZATION_AXIOM_TOKEN ( ( ruleReference ) ) ) )
            // InternalOntologicalModelingLanguage.g:3013:2: ( ( ( ruleReference ) ) this_ASPECT_SPECIALIZATION_AXIOM_TOKEN_1= RULE_ASPECT_SPECIALIZATION_AXIOM_TOKEN ( ( ruleReference ) ) )
            {
            // InternalOntologicalModelingLanguage.g:3013:2: ( ( ( ruleReference ) ) this_ASPECT_SPECIALIZATION_AXIOM_TOKEN_1= RULE_ASPECT_SPECIALIZATION_AXIOM_TOKEN ( ( ruleReference ) ) )
            // InternalOntologicalModelingLanguage.g:3014:3: ( ( ruleReference ) ) this_ASPECT_SPECIALIZATION_AXIOM_TOKEN_1= RULE_ASPECT_SPECIALIZATION_AXIOM_TOKEN ( ( ruleReference ) )
            {
            // InternalOntologicalModelingLanguage.g:3014:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3015:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3015:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3016:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_0_0());
            				
            pushFollow(FOLLOW_53);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_ASPECT_SPECIALIZATION_AXIOM_TOKEN_1=(Token)match(input,RULE_ASPECT_SPECIALIZATION_AXIOM_TOKEN,FOLLOW_28); 

            			newLeafNode(this_ASPECT_SPECIALIZATION_AXIOM_TOKEN_1, grammarAccess.getAspectSpecializationAxiomAccess().getASPECT_SPECIALIZATION_AXIOM_TOKENTerminalRuleCall_1());
            		
            // InternalOntologicalModelingLanguage.g:3034:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3035:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3035:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3036:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAspectSpecializationAxiom"


    // $ANTLR start "entryRuleConceptSpecializationAxiom"
    // InternalOntologicalModelingLanguage.g:3054:1: entryRuleConceptSpecializationAxiom returns [EObject current=null] : iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF ;
    public final EObject entryRuleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptSpecializationAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:3054:67: (iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF )
            // InternalOntologicalModelingLanguage.g:3055:2: iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF
            {
             newCompositeNode(grammarAccess.getConceptSpecializationAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConceptSpecializationAxiom=ruleConceptSpecializationAxiom();

            state._fsp--;

             current =iv_ruleConceptSpecializationAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConceptSpecializationAxiom"


    // $ANTLR start "ruleConceptSpecializationAxiom"
    // InternalOntologicalModelingLanguage.g:3061:1: ruleConceptSpecializationAxiom returns [EObject current=null] : (this_CONCEPT_SPECIALIZATION_AXIOM_TOKEN_0= RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subConcept' ( ( ruleReference ) ) otherlv_4= 'superConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) ;
    public final EObject ruleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token this_CONCEPT_SPECIALIZATION_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_RCURLY_6=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3067:2: ( (this_CONCEPT_SPECIALIZATION_AXIOM_TOKEN_0= RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subConcept' ( ( ruleReference ) ) otherlv_4= 'superConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:3068:2: (this_CONCEPT_SPECIALIZATION_AXIOM_TOKEN_0= RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subConcept' ( ( ruleReference ) ) otherlv_4= 'superConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:3068:2: (this_CONCEPT_SPECIALIZATION_AXIOM_TOKEN_0= RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subConcept' ( ( ruleReference ) ) otherlv_4= 'superConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:3069:3: this_CONCEPT_SPECIALIZATION_AXIOM_TOKEN_0= RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subConcept' ( ( ruleReference ) ) otherlv_4= 'superConcept' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY
            {
            this_CONCEPT_SPECIALIZATION_AXIOM_TOKEN_0=(Token)match(input,RULE_CONCEPT_SPECIALIZATION_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_CONCEPT_SPECIALIZATION_AXIOM_TOKEN_0, grammarAccess.getConceptSpecializationAxiomAccess().getCONCEPT_SPECIALIZATION_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_54); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getConceptSpecializationAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,88,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:3081:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3082:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3082:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3083:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_3_0());
            				
            pushFollow(FOLLOW_55);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,89,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:3101:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3102:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3102:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3103:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_6, grammarAccess.getConceptSpecializationAxiomAccess().getRCURLYTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConceptSpecializationAxiom"


    // $ANTLR start "entryRuleReifiedRelationshipSpecializationAxiom"
    // InternalOntologicalModelingLanguage.g:3125:1: entryRuleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF ;
    public final EObject entryRuleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipSpecializationAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:3125:79: (iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF )
            // InternalOntologicalModelingLanguage.g:3126:2: iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF
            {
             newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReifiedRelationshipSpecializationAxiom=ruleReifiedRelationshipSpecializationAxiom();

            state._fsp--;

             current =iv_ruleReifiedRelationshipSpecializationAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReifiedRelationshipSpecializationAxiom"


    // $ANTLR start "ruleReifiedRelationshipSpecializationAxiom"
    // InternalOntologicalModelingLanguage.g:3132:1: ruleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : (this_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN_0= RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subRelationship' ( ( ruleReference ) ) otherlv_4= 'superRelationship' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) ;
    public final EObject ruleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token this_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_RCURLY_6=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3138:2: ( (this_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN_0= RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subRelationship' ( ( ruleReference ) ) otherlv_4= 'superRelationship' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:3139:2: (this_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN_0= RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subRelationship' ( ( ruleReference ) ) otherlv_4= 'superRelationship' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:3139:2: (this_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN_0= RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subRelationship' ( ( ruleReference ) ) otherlv_4= 'superRelationship' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:3140:3: this_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN_0= RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'subRelationship' ( ( ruleReference ) ) otherlv_4= 'superRelationship' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY
            {
            this_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN_0=(Token)match(input,RULE_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKEN_0, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getREIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_56); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,90,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:3152:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3153:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3153:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3154:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_57);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,91,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:3172:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3173:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3173:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3174:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipCrossReference_5_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_6, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getRCURLYTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReifiedRelationshipSpecializationAxiom"


    // $ANTLR start "entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:3196:1: entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:3196:92: (iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF )
            // InternalOntologicalModelingLanguage.g:3197:2: iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom=ruleEntityScalarDataPropertyExistentialRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom"


    // $ANTLR start "ruleEntityScalarDataPropertyExistentialRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:3203:1: ruleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : (this_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY ) ;
    public final EObject ruleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token this_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_RCURLY_8=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3209:2: ( (this_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:3210:2: (this_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:3210:2: (this_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:3211:3: this_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY
            {
            this_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0=(Token)match(input,RULE_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKEN_0, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_58); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,92,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:3223:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3224:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3224:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3225:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_3_0());
            				
            pushFollow(FOLLOW_59);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,93,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:3243:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3244:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3244:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3245:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_5_0());
            				
            pushFollow(FOLLOW_60);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,94,FOLLOW_28); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionKeyword_6());
            		
            // InternalOntologicalModelingLanguage.g:3263:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3264:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3264:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3265:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_7_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_8, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRCURLYTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataPropertyExistentialRestrictionAxiom"


    // $ANTLR start "entryRuleEntityScalarDataPropertyParticularRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:3287:1: entryRuleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:3287:91: (iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF )
            // InternalOntologicalModelingLanguage.g:3288:2: iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom=ruleEntityScalarDataPropertyParticularRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataPropertyParticularRestrictionAxiom"


    // $ANTLR start "ruleEntityScalarDataPropertyParticularRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:3294:1: ruleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : (this_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'literalValue' ( (lv_literalValue_7_0= RULE_STRING ) ) this_RCURLY_8= RULE_RCURLY ) ;
    public final EObject ruleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token this_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_literalValue_7_0=null;
        Token this_RCURLY_8=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3300:2: ( (this_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'literalValue' ( (lv_literalValue_7_0= RULE_STRING ) ) this_RCURLY_8= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:3301:2: (this_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'literalValue' ( (lv_literalValue_7_0= RULE_STRING ) ) this_RCURLY_8= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:3301:2: (this_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'literalValue' ( (lv_literalValue_7_0= RULE_STRING ) ) this_RCURLY_8= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:3302:3: this_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'literalValue' ( (lv_literalValue_7_0= RULE_STRING ) ) this_RCURLY_8= RULE_RCURLY
            {
            this_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN_0=(Token)match(input,RULE_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKEN_0, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_58); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,92,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:3314:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3315:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3315:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3316:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_3_0());
            				
            pushFollow(FOLLOW_59);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,93,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:3334:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3335:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3335:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3336:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_5_0());
            				
            pushFollow(FOLLOW_61);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,95,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueKeyword_6());
            		
            // InternalOntologicalModelingLanguage.g:3354:3: ( (lv_literalValue_7_0= RULE_STRING ) )
            // InternalOntologicalModelingLanguage.g:3355:4: (lv_literalValue_7_0= RULE_STRING )
            {
            // InternalOntologicalModelingLanguage.g:3355:4: (lv_literalValue_7_0= RULE_STRING )
            // InternalOntologicalModelingLanguage.g:3356:5: lv_literalValue_7_0= RULE_STRING
            {
            lv_literalValue_7_0=(Token)match(input,RULE_STRING,FOLLOW_30); 

            					newLeafNode(lv_literalValue_7_0, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"literalValue",
            						lv_literalValue_7_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
            				

            }


            }

            this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_8, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRCURLYTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataPropertyParticularRestrictionAxiom"


    // $ANTLR start "entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:3380:1: entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:3380:90: (iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF )
            // InternalOntologicalModelingLanguage.g:3381:2: iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom=ruleEntityScalarDataPropertyUniversalRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom"


    // $ANTLR start "ruleEntityScalarDataPropertyUniversalRestrictionAxiom"
    // InternalOntologicalModelingLanguage.g:3387:1: ruleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : (this_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY ) ;
    public final EObject ruleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token this_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_RCURLY_8=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3393:2: ( (this_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:3394:2: (this_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:3394:2: (this_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:3395:3: this_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0= RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'restrictedEntity' ( ( ruleReference ) ) otherlv_4= 'scalarProperty' ( ( ruleReference ) ) otherlv_6= 'scalarRestriction' ( ( ruleReference ) ) this_RCURLY_8= RULE_RCURLY
            {
            this_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0=(Token)match(input,RULE_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKEN_0, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_58); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,92,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:3407:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3408:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3408:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3409:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_3_0());
            				
            pushFollow(FOLLOW_59);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,93,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:3427:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3428:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3428:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3429:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_5_0());
            				
            pushFollow(FOLLOW_60);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,94,FOLLOW_28); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionKeyword_6());
            		
            // InternalOntologicalModelingLanguage.g:3447:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3448:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3448:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3449:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_7_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_8, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRCURLYTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataPropertyUniversalRestrictionAxiom"


    // $ANTLR start "entryRuleBinaryScalarRestriction"
    // InternalOntologicalModelingLanguage.g:3471:1: entryRuleBinaryScalarRestriction returns [EObject current=null] : iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF ;
    public final EObject entryRuleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryScalarRestriction = null;


        try {
            // InternalOntologicalModelingLanguage.g:3471:64: (iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF )
            // InternalOntologicalModelingLanguage.g:3472:2: iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getBinaryScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryScalarRestriction=ruleBinaryScalarRestriction();

            state._fsp--;

             current =iv_ruleBinaryScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryScalarRestriction"


    // $ANTLR start "ruleBinaryScalarRestriction"
    // InternalOntologicalModelingLanguage.g:3478:1: ruleBinaryScalarRestriction returns [EObject current=null] : (this_BINARY_SCALAR_RESTRICTION_TOKEN_0= RULE_BINARY_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? otherlv_9= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_11= RULE_RCURLY ) ;
    public final EObject ruleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token this_BINARY_SCALAR_RESTRICTION_TOKEN_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token otherlv_3=null;
        Token lv_length_4_0=null;
        Token otherlv_5=null;
        Token lv_minLength_6_0=null;
        Token otherlv_7=null;
        Token lv_maxLength_8_0=null;
        Token otherlv_9=null;
        Token this_RCURLY_11=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3484:2: ( (this_BINARY_SCALAR_RESTRICTION_TOKEN_0= RULE_BINARY_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? otherlv_9= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_11= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:3485:2: (this_BINARY_SCALAR_RESTRICTION_TOKEN_0= RULE_BINARY_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? otherlv_9= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_11= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:3485:2: (this_BINARY_SCALAR_RESTRICTION_TOKEN_0= RULE_BINARY_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? otherlv_9= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_11= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:3486:3: this_BINARY_SCALAR_RESTRICTION_TOKEN_0= RULE_BINARY_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? otherlv_9= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_11= RULE_RCURLY
            {
            this_BINARY_SCALAR_RESTRICTION_TOKEN_0=(Token)match(input,RULE_BINARY_SCALAR_RESTRICTION_TOKEN,FOLLOW_5); 

            			newLeafNode(this_BINARY_SCALAR_RESTRICTION_TOKEN_0, grammarAccess.getBinaryScalarRestrictionAccess().getBINARY_SCALAR_RESTRICTION_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:3490:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:3491:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:3491:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:3492:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_62); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getBinaryScalarRestrictionAccess().getLCURLYTerminalRuleCall_2());
            		
            // InternalOntologicalModelingLanguage.g:3512:3: (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==96) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3513:4: otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,96,FOLLOW_63); 

                    				newLeafNode(otherlv_3, grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_3_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3517:4: ( (lv_length_4_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:3518:5: (lv_length_4_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:3518:5: (lv_length_4_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:3519:6: lv_length_4_0= RULE_INT
                    {
                    lv_length_4_0=(Token)match(input,RULE_INT,FOLLOW_64); 

                    						newLeafNode(lv_length_4_0, grammarAccess.getBinaryScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"length",
                    							lv_length_4_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:3536:3: (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==97) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3537:4: otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) )
                    {
                    otherlv_5=(Token)match(input,97,FOLLOW_63); 

                    				newLeafNode(otherlv_5, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_4_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3541:4: ( (lv_minLength_6_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:3542:5: (lv_minLength_6_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:3542:5: (lv_minLength_6_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:3543:6: lv_minLength_6_0= RULE_INT
                    {
                    lv_minLength_6_0=(Token)match(input,RULE_INT,FOLLOW_65); 

                    						newLeafNode(lv_minLength_6_0, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minLength",
                    							lv_minLength_6_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:3560:3: (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==98) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3561:4: otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) )
                    {
                    otherlv_7=(Token)match(input,98,FOLLOW_63); 

                    				newLeafNode(otherlv_7, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_5_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3565:4: ( (lv_maxLength_8_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:3566:5: (lv_maxLength_8_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:3566:5: (lv_maxLength_8_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:3567:6: lv_maxLength_8_0= RULE_INT
                    {
                    lv_maxLength_8_0=(Token)match(input,RULE_INT,FOLLOW_51); 

                    						newLeafNode(lv_maxLength_8_0, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"maxLength",
                    							lv_maxLength_8_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_9, grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_6());
            		
            // InternalOntologicalModelingLanguage.g:3588:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3589:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3589:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3590:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_7_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_11=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_11, grammarAccess.getBinaryScalarRestrictionAccess().getRCURLYTerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryScalarRestriction"


    // $ANTLR start "entryRuleIRIScalarRestriction"
    // InternalOntologicalModelingLanguage.g:3612:1: entryRuleIRIScalarRestriction returns [EObject current=null] : iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF ;
    public final EObject entryRuleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIRIScalarRestriction = null;


        try {
            // InternalOntologicalModelingLanguage.g:3612:61: (iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF )
            // InternalOntologicalModelingLanguage.g:3613:2: iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getIRIScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIRIScalarRestriction=ruleIRIScalarRestriction();

            state._fsp--;

             current =iv_ruleIRIScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIRIScalarRestriction"


    // $ANTLR start "ruleIRIScalarRestriction"
    // InternalOntologicalModelingLanguage.g:3619:1: ruleIRIScalarRestriction returns [EObject current=null] : (this_IRI_SCALAR_RESTRICTION_TOKEN_0= RULE_IRI_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY ) ;
    public final EObject ruleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token this_IRI_SCALAR_RESTRICTION_TOKEN_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token otherlv_3=null;
        Token lv_length_4_0=null;
        Token otherlv_5=null;
        Token lv_minLength_6_0=null;
        Token otherlv_7=null;
        Token lv_maxLength_8_0=null;
        Token otherlv_9=null;
        Token lv_pattern_10_0=null;
        Token otherlv_11=null;
        Token this_RCURLY_13=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3625:2: ( (this_IRI_SCALAR_RESTRICTION_TOKEN_0= RULE_IRI_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:3626:2: (this_IRI_SCALAR_RESTRICTION_TOKEN_0= RULE_IRI_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:3626:2: (this_IRI_SCALAR_RESTRICTION_TOKEN_0= RULE_IRI_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:3627:3: this_IRI_SCALAR_RESTRICTION_TOKEN_0= RULE_IRI_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY
            {
            this_IRI_SCALAR_RESTRICTION_TOKEN_0=(Token)match(input,RULE_IRI_SCALAR_RESTRICTION_TOKEN,FOLLOW_5); 

            			newLeafNode(this_IRI_SCALAR_RESTRICTION_TOKEN_0, grammarAccess.getIRIScalarRestrictionAccess().getIRI_SCALAR_RESTRICTION_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:3631:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:3632:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:3632:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:3633:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_66); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getIRIScalarRestrictionAccess().getLCURLYTerminalRuleCall_2());
            		
            // InternalOntologicalModelingLanguage.g:3653:3: (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==96) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3654:4: otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,96,FOLLOW_63); 

                    				newLeafNode(otherlv_3, grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_3_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3658:4: ( (lv_length_4_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:3659:5: (lv_length_4_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:3659:5: (lv_length_4_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:3660:6: lv_length_4_0= RULE_INT
                    {
                    lv_length_4_0=(Token)match(input,RULE_INT,FOLLOW_67); 

                    						newLeafNode(lv_length_4_0, grammarAccess.getIRIScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"length",
                    							lv_length_4_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:3677:3: (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==97) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3678:4: otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) )
                    {
                    otherlv_5=(Token)match(input,97,FOLLOW_63); 

                    				newLeafNode(otherlv_5, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_4_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3682:4: ( (lv_minLength_6_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:3683:5: (lv_minLength_6_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:3683:5: (lv_minLength_6_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:3684:6: lv_minLength_6_0= RULE_INT
                    {
                    lv_minLength_6_0=(Token)match(input,RULE_INT,FOLLOW_68); 

                    						newLeafNode(lv_minLength_6_0, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minLength",
                    							lv_minLength_6_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:3701:3: (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==98) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3702:4: otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) )
                    {
                    otherlv_7=(Token)match(input,98,FOLLOW_63); 

                    				newLeafNode(otherlv_7, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_5_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3706:4: ( (lv_maxLength_8_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:3707:5: (lv_maxLength_8_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:3707:5: (lv_maxLength_8_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:3708:6: lv_maxLength_8_0= RULE_INT
                    {
                    lv_maxLength_8_0=(Token)match(input,RULE_INT,FOLLOW_69); 

                    						newLeafNode(lv_maxLength_8_0, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"maxLength",
                    							lv_maxLength_8_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:3725:3: (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==99) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3726:4: otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,99,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_6_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3730:4: ( (lv_pattern_10_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:3731:5: (lv_pattern_10_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:3731:5: (lv_pattern_10_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:3732:6: lv_pattern_10_0= RULE_STRING
                    {
                    lv_pattern_10_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

                    						newLeafNode(lv_pattern_10_0, grammarAccess.getIRIScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"pattern",
                    							lv_pattern_10_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_11, grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_7());
            		
            // InternalOntologicalModelingLanguage.g:3753:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3754:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3754:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3755:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_8_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_13=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_13, grammarAccess.getIRIScalarRestrictionAccess().getRCURLYTerminalRuleCall_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIRIScalarRestriction"


    // $ANTLR start "entryRuleNumericScalarRestriction"
    // InternalOntologicalModelingLanguage.g:3777:1: entryRuleNumericScalarRestriction returns [EObject current=null] : iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF ;
    public final EObject entryRuleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericScalarRestriction = null;


        try {
            // InternalOntologicalModelingLanguage.g:3777:65: (iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF )
            // InternalOntologicalModelingLanguage.g:3778:2: iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getNumericScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericScalarRestriction=ruleNumericScalarRestriction();

            state._fsp--;

             current =iv_ruleNumericScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericScalarRestriction"


    // $ANTLR start "ruleNumericScalarRestriction"
    // InternalOntologicalModelingLanguage.g:3784:1: ruleNumericScalarRestriction returns [EObject current=null] : (this_NUMERIC_SCALAR_RESTRICTION_TOKEN_0= RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY ) ;
    public final EObject ruleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token this_NUMERIC_SCALAR_RESTRICTION_TOKEN_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token otherlv_3=null;
        Token lv_minInclusive_4_0=null;
        Token otherlv_5=null;
        Token lv_maxInclusive_6_0=null;
        Token otherlv_7=null;
        Token lv_minExclusive_8_0=null;
        Token otherlv_9=null;
        Token lv_maxExclusive_10_0=null;
        Token otherlv_11=null;
        Token this_RCURLY_13=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3790:2: ( (this_NUMERIC_SCALAR_RESTRICTION_TOKEN_0= RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:3791:2: (this_NUMERIC_SCALAR_RESTRICTION_TOKEN_0= RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:3791:2: (this_NUMERIC_SCALAR_RESTRICTION_TOKEN_0= RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:3792:3: this_NUMERIC_SCALAR_RESTRICTION_TOKEN_0= RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY
            {
            this_NUMERIC_SCALAR_RESTRICTION_TOKEN_0=(Token)match(input,RULE_NUMERIC_SCALAR_RESTRICTION_TOKEN,FOLLOW_5); 

            			newLeafNode(this_NUMERIC_SCALAR_RESTRICTION_TOKEN_0, grammarAccess.getNumericScalarRestrictionAccess().getNUMERIC_SCALAR_RESTRICTION_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:3796:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:3797:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:3797:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:3798:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_70); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getNumericScalarRestrictionAccess().getLCURLYTerminalRuleCall_2());
            		
            // InternalOntologicalModelingLanguage.g:3818:3: (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==100) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3819:4: otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,100,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_3_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3823:4: ( (lv_minInclusive_4_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:3824:5: (lv_minInclusive_4_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:3824:5: (lv_minInclusive_4_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:3825:6: lv_minInclusive_4_0= RULE_STRING
                    {
                    lv_minInclusive_4_0=(Token)match(input,RULE_STRING,FOLLOW_71); 

                    						newLeafNode(lv_minInclusive_4_0, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minInclusive",
                    							lv_minInclusive_4_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:3842:3: (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==101) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3843:4: otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,101,FOLLOW_8); 

                    				newLeafNode(otherlv_5, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_4_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3847:4: ( (lv_maxInclusive_6_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:3848:5: (lv_maxInclusive_6_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:3848:5: (lv_maxInclusive_6_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:3849:6: lv_maxInclusive_6_0= RULE_STRING
                    {
                    lv_maxInclusive_6_0=(Token)match(input,RULE_STRING,FOLLOW_72); 

                    						newLeafNode(lv_maxInclusive_6_0, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"maxInclusive",
                    							lv_maxInclusive_6_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:3866:3: (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==102) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3867:4: otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,102,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_5_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3871:4: ( (lv_minExclusive_8_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:3872:5: (lv_minExclusive_8_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:3872:5: (lv_minExclusive_8_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:3873:6: lv_minExclusive_8_0= RULE_STRING
                    {
                    lv_minExclusive_8_0=(Token)match(input,RULE_STRING,FOLLOW_73); 

                    						newLeafNode(lv_minExclusive_8_0, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minExclusive",
                    							lv_minExclusive_8_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:3890:3: (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==103) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3891:4: otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,103,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_6_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3895:4: ( (lv_maxExclusive_10_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:3896:5: (lv_maxExclusive_10_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:3896:5: (lv_maxExclusive_10_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:3897:6: lv_maxExclusive_10_0= RULE_STRING
                    {
                    lv_maxExclusive_10_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

                    						newLeafNode(lv_maxExclusive_10_0, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"maxExclusive",
                    							lv_maxExclusive_10_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_11, grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_7());
            		
            // InternalOntologicalModelingLanguage.g:3918:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:3919:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:3919:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:3920:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_8_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_13=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_13, grammarAccess.getNumericScalarRestrictionAccess().getRCURLYTerminalRuleCall_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericScalarRestriction"


    // $ANTLR start "entryRulePlainLiteralScalarRestriction"
    // InternalOntologicalModelingLanguage.g:3942:1: entryRulePlainLiteralScalarRestriction returns [EObject current=null] : iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF ;
    public final EObject entryRulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlainLiteralScalarRestriction = null;


        try {
            // InternalOntologicalModelingLanguage.g:3942:70: (iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF )
            // InternalOntologicalModelingLanguage.g:3943:2: iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlainLiteralScalarRestriction=rulePlainLiteralScalarRestriction();

            state._fsp--;

             current =iv_rulePlainLiteralScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlainLiteralScalarRestriction"


    // $ANTLR start "rulePlainLiteralScalarRestriction"
    // InternalOntologicalModelingLanguage.g:3949:1: rulePlainLiteralScalarRestriction returns [EObject current=null] : (this_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN_0= RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? (otherlv_11= 'language' ( (lv_language_12_0= RULE_STRING ) ) )? otherlv_13= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_15= RULE_RCURLY ) ;
    public final EObject rulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token this_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token otherlv_3=null;
        Token lv_length_4_0=null;
        Token otherlv_5=null;
        Token lv_minLength_6_0=null;
        Token otherlv_7=null;
        Token lv_maxLength_8_0=null;
        Token otherlv_9=null;
        Token lv_pattern_10_0=null;
        Token otherlv_11=null;
        Token lv_language_12_0=null;
        Token otherlv_13=null;
        Token this_RCURLY_15=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:3955:2: ( (this_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN_0= RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? (otherlv_11= 'language' ( (lv_language_12_0= RULE_STRING ) ) )? otherlv_13= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_15= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:3956:2: (this_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN_0= RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? (otherlv_11= 'language' ( (lv_language_12_0= RULE_STRING ) ) )? otherlv_13= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_15= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:3956:2: (this_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN_0= RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? (otherlv_11= 'language' ( (lv_language_12_0= RULE_STRING ) ) )? otherlv_13= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_15= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:3957:3: this_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN_0= RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? (otherlv_11= 'language' ( (lv_language_12_0= RULE_STRING ) ) )? otherlv_13= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_15= RULE_RCURLY
            {
            this_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN_0=(Token)match(input,RULE_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN,FOLLOW_5); 

            			newLeafNode(this_PLAIN_LITERAL_SCALAR_RESTRICTION_TOKEN_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPLAIN_LITERAL_SCALAR_RESTRICTION_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:3961:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:3962:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:3962:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:3963:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_74); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLCURLYTerminalRuleCall_2());
            		
            // InternalOntologicalModelingLanguage.g:3983:3: (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==96) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:3984:4: otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,96,FOLLOW_63); 

                    				newLeafNode(otherlv_3, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_3_0());
                    			
                    // InternalOntologicalModelingLanguage.g:3988:4: ( (lv_length_4_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:3989:5: (lv_length_4_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:3989:5: (lv_length_4_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:3990:6: lv_length_4_0= RULE_INT
                    {
                    lv_length_4_0=(Token)match(input,RULE_INT,FOLLOW_75); 

                    						newLeafNode(lv_length_4_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"length",
                    							lv_length_4_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4007:3: (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==97) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4008:4: otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) )
                    {
                    otherlv_5=(Token)match(input,97,FOLLOW_63); 

                    				newLeafNode(otherlv_5, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_4_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4012:4: ( (lv_minLength_6_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:4013:5: (lv_minLength_6_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:4013:5: (lv_minLength_6_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:4014:6: lv_minLength_6_0= RULE_INT
                    {
                    lv_minLength_6_0=(Token)match(input,RULE_INT,FOLLOW_76); 

                    						newLeafNode(lv_minLength_6_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minLength",
                    							lv_minLength_6_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4031:3: (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==98) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4032:4: otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) )
                    {
                    otherlv_7=(Token)match(input,98,FOLLOW_63); 

                    				newLeafNode(otherlv_7, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_5_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4036:4: ( (lv_maxLength_8_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:4037:5: (lv_maxLength_8_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:4037:5: (lv_maxLength_8_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:4038:6: lv_maxLength_8_0= RULE_INT
                    {
                    lv_maxLength_8_0=(Token)match(input,RULE_INT,FOLLOW_77); 

                    						newLeafNode(lv_maxLength_8_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"maxLength",
                    							lv_maxLength_8_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4055:3: (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==99) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4056:4: otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,99,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_6_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4060:4: ( (lv_pattern_10_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:4061:5: (lv_pattern_10_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:4061:5: (lv_pattern_10_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:4062:6: lv_pattern_10_0= RULE_STRING
                    {
                    lv_pattern_10_0=(Token)match(input,RULE_STRING,FOLLOW_78); 

                    						newLeafNode(lv_pattern_10_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"pattern",
                    							lv_pattern_10_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4079:3: (otherlv_11= 'language' ( (lv_language_12_0= RULE_STRING ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==104) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4080:4: otherlv_11= 'language' ( (lv_language_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,104,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLanguageKeyword_7_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4084:4: ( (lv_language_12_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:4085:5: (lv_language_12_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:4085:5: (lv_language_12_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:4086:6: lv_language_12_0= RULE_STRING
                    {
                    lv_language_12_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

                    						newLeafNode(lv_language_12_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLanguageSTRINGTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"language",
                    							lv_language_12_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_13, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_8());
            		
            // InternalOntologicalModelingLanguage.g:4107:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:4108:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:4108:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:4109:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_9_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_15=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_15, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRCURLYTerminalRuleCall_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlainLiteralScalarRestriction"


    // $ANTLR start "entryRuleScalarOneOfRestriction"
    // InternalOntologicalModelingLanguage.g:4131:1: entryRuleScalarOneOfRestriction returns [EObject current=null] : iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF ;
    public final EObject entryRuleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfRestriction = null;


        try {
            // InternalOntologicalModelingLanguage.g:4131:63: (iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF )
            // InternalOntologicalModelingLanguage.g:4132:2: iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF
            {
             newCompositeNode(grammarAccess.getScalarOneOfRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarOneOfRestriction=ruleScalarOneOfRestriction();

            state._fsp--;

             current =iv_ruleScalarOneOfRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarOneOfRestriction"


    // $ANTLR start "ruleScalarOneOfRestriction"
    // InternalOntologicalModelingLanguage.g:4138:1: ruleScalarOneOfRestriction returns [EObject current=null] : (this_SCALAR_ONE_OF_RESTRICTION_TOKEN_0= RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY ) ;
    public final EObject ruleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        Token this_SCALAR_ONE_OF_RESTRICTION_TOKEN_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token otherlv_3=null;
        Token this_RCURLY_5=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4144:2: ( (this_SCALAR_ONE_OF_RESTRICTION_TOKEN_0= RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:4145:2: (this_SCALAR_ONE_OF_RESTRICTION_TOKEN_0= RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:4145:2: (this_SCALAR_ONE_OF_RESTRICTION_TOKEN_0= RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:4146:3: this_SCALAR_ONE_OF_RESTRICTION_TOKEN_0= RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY
            {
            this_SCALAR_ONE_OF_RESTRICTION_TOKEN_0=(Token)match(input,RULE_SCALAR_ONE_OF_RESTRICTION_TOKEN,FOLLOW_5); 

            			newLeafNode(this_SCALAR_ONE_OF_RESTRICTION_TOKEN_0, grammarAccess.getScalarOneOfRestrictionAccess().getSCALAR_ONE_OF_RESTRICTION_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:4150:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:4151:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:4151:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:4152:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_51); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getScalarOneOfRestrictionAccess().getLCURLYTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_3());
            		
            // InternalOntologicalModelingLanguage.g:4176:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:4177:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:4177:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:4178:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_5=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_5, grammarAccess.getScalarOneOfRestrictionAccess().getRCURLYTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarOneOfRestriction"


    // $ANTLR start "entryRuleScalarOneOfLiteralAxiom"
    // InternalOntologicalModelingLanguage.g:4200:1: entryRuleScalarOneOfLiteralAxiom returns [EObject current=null] : iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF ;
    public final EObject entryRuleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfLiteralAxiom = null;


        try {
            // InternalOntologicalModelingLanguage.g:4200:64: (iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF )
            // InternalOntologicalModelingLanguage.g:4201:2: iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF
            {
             newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarOneOfLiteralAxiom=ruleScalarOneOfLiteralAxiom();

            state._fsp--;

             current =iv_ruleScalarOneOfLiteralAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarOneOfLiteralAxiom"


    // $ANTLR start "ruleScalarOneOfLiteralAxiom"
    // InternalOntologicalModelingLanguage.g:4207:1: ruleScalarOneOfLiteralAxiom returns [EObject current=null] : (this_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN_0= RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= 'axiom' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) ;
    public final EObject ruleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        Token this_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN_0=null;
        Token this_LCURLY_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;
        Token this_RCURLY_6=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4213:2: ( (this_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN_0= RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= 'axiom' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:4214:2: (this_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN_0= RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= 'axiom' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:4214:2: (this_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN_0= RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= 'axiom' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:4215:3: this_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN_0= RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN this_LCURLY_1= RULE_LCURLY otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= 'axiom' ( ( ruleReference ) ) this_RCURLY_6= RULE_RCURLY
            {
            this_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN_0=(Token)match(input,RULE_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN,FOLLOW_10); 

            			newLeafNode(this_SCALAR_ONE_OF_LITERAL_AXIOM_TOKEN_0, grammarAccess.getScalarOneOfLiteralAxiomAccess().getSCALAR_ONE_OF_LITERAL_AXIOM_TOKENTerminalRuleCall_0());
            		
            this_LCURLY_1=(Token)match(input,RULE_LCURLY,FOLLOW_79); 

            			newLeafNode(this_LCURLY_1, grammarAccess.getScalarOneOfLiteralAxiomAccess().getLCURLYTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,105,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueKeyword_2());
            		
            // InternalOntologicalModelingLanguage.g:4227:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOntologicalModelingLanguage.g:4228:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOntologicalModelingLanguage.g:4228:4: (lv_value_3_0= RULE_STRING )
            // InternalOntologicalModelingLanguage.g:4229:5: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_80); 

            					newLeafNode(lv_value_3_0, grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_3_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,106,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomKeyword_4());
            		
            // InternalOntologicalModelingLanguage.g:4249:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:4250:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:4250:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:4251:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionCrossReference_5_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_6, grammarAccess.getScalarOneOfLiteralAxiomAccess().getRCURLYTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarOneOfLiteralAxiom"


    // $ANTLR start "entryRuleStringScalarRestriction"
    // InternalOntologicalModelingLanguage.g:4273:1: entryRuleStringScalarRestriction returns [EObject current=null] : iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF ;
    public final EObject entryRuleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringScalarRestriction = null;


        try {
            // InternalOntologicalModelingLanguage.g:4273:64: (iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF )
            // InternalOntologicalModelingLanguage.g:4274:2: iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getStringScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringScalarRestriction=ruleStringScalarRestriction();

            state._fsp--;

             current =iv_ruleStringScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringScalarRestriction"


    // $ANTLR start "ruleStringScalarRestriction"
    // InternalOntologicalModelingLanguage.g:4280:1: ruleStringScalarRestriction returns [EObject current=null] : (this_STRING_SCALAR_RESTRICTION_TOKEN_0= RULE_STRING_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY ) ;
    public final EObject ruleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token this_STRING_SCALAR_RESTRICTION_TOKEN_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token otherlv_3=null;
        Token lv_length_4_0=null;
        Token otherlv_5=null;
        Token lv_minLength_6_0=null;
        Token otherlv_7=null;
        Token lv_maxLength_8_0=null;
        Token otherlv_9=null;
        Token lv_pattern_10_0=null;
        Token otherlv_11=null;
        Token this_RCURLY_13=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4286:2: ( (this_STRING_SCALAR_RESTRICTION_TOKEN_0= RULE_STRING_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:4287:2: (this_STRING_SCALAR_RESTRICTION_TOKEN_0= RULE_STRING_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:4287:2: (this_STRING_SCALAR_RESTRICTION_TOKEN_0= RULE_STRING_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:4288:3: this_STRING_SCALAR_RESTRICTION_TOKEN_0= RULE_STRING_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )? (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )? (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )? (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY
            {
            this_STRING_SCALAR_RESTRICTION_TOKEN_0=(Token)match(input,RULE_STRING_SCALAR_RESTRICTION_TOKEN,FOLLOW_5); 

            			newLeafNode(this_STRING_SCALAR_RESTRICTION_TOKEN_0, grammarAccess.getStringScalarRestrictionAccess().getSTRING_SCALAR_RESTRICTION_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:4292:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:4293:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:4293:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:4294:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_66); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getStringScalarRestrictionAccess().getLCURLYTerminalRuleCall_2());
            		
            // InternalOntologicalModelingLanguage.g:4314:3: (otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==96) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4315:4: otherlv_3= 'length' ( (lv_length_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,96,FOLLOW_63); 

                    				newLeafNode(otherlv_3, grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_3_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4319:4: ( (lv_length_4_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:4320:5: (lv_length_4_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:4320:5: (lv_length_4_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:4321:6: lv_length_4_0= RULE_INT
                    {
                    lv_length_4_0=(Token)match(input,RULE_INT,FOLLOW_67); 

                    						newLeafNode(lv_length_4_0, grammarAccess.getStringScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"length",
                    							lv_length_4_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4338:3: (otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==97) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4339:4: otherlv_5= 'minLength' ( (lv_minLength_6_0= RULE_INT ) )
                    {
                    otherlv_5=(Token)match(input,97,FOLLOW_63); 

                    				newLeafNode(otherlv_5, grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_4_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4343:4: ( (lv_minLength_6_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:4344:5: (lv_minLength_6_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:4344:5: (lv_minLength_6_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:4345:6: lv_minLength_6_0= RULE_INT
                    {
                    lv_minLength_6_0=(Token)match(input,RULE_INT,FOLLOW_68); 

                    						newLeafNode(lv_minLength_6_0, grammarAccess.getStringScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minLength",
                    							lv_minLength_6_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4362:3: (otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==98) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4363:4: otherlv_7= 'maxLength' ( (lv_maxLength_8_0= RULE_INT ) )
                    {
                    otherlv_7=(Token)match(input,98,FOLLOW_63); 

                    				newLeafNode(otherlv_7, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_5_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4367:4: ( (lv_maxLength_8_0= RULE_INT ) )
                    // InternalOntologicalModelingLanguage.g:4368:5: (lv_maxLength_8_0= RULE_INT )
                    {
                    // InternalOntologicalModelingLanguage.g:4368:5: (lv_maxLength_8_0= RULE_INT )
                    // InternalOntologicalModelingLanguage.g:4369:6: lv_maxLength_8_0= RULE_INT
                    {
                    lv_maxLength_8_0=(Token)match(input,RULE_INT,FOLLOW_69); 

                    						newLeafNode(lv_maxLength_8_0, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"maxLength",
                    							lv_maxLength_8_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4386:3: (otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==99) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4387:4: otherlv_9= 'pattern' ( (lv_pattern_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,99,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_6_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4391:4: ( (lv_pattern_10_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:4392:5: (lv_pattern_10_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:4392:5: (lv_pattern_10_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:4393:6: lv_pattern_10_0= RULE_STRING
                    {
                    lv_pattern_10_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

                    						newLeafNode(lv_pattern_10_0, grammarAccess.getStringScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"pattern",
                    							lv_pattern_10_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_11, grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_7());
            		
            // InternalOntologicalModelingLanguage.g:4414:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:4415:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:4415:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:4416:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_8_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_13=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_13, grammarAccess.getStringScalarRestrictionAccess().getRCURLYTerminalRuleCall_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringScalarRestriction"


    // $ANTLR start "entryRuleSynonymScalarRestriction"
    // InternalOntologicalModelingLanguage.g:4438:1: entryRuleSynonymScalarRestriction returns [EObject current=null] : iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF ;
    public final EObject entryRuleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynonymScalarRestriction = null;


        try {
            // InternalOntologicalModelingLanguage.g:4438:65: (iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF )
            // InternalOntologicalModelingLanguage.g:4439:2: iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getSynonymScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSynonymScalarRestriction=ruleSynonymScalarRestriction();

            state._fsp--;

             current =iv_ruleSynonymScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSynonymScalarRestriction"


    // $ANTLR start "ruleSynonymScalarRestriction"
    // InternalOntologicalModelingLanguage.g:4445:1: ruleSynonymScalarRestriction returns [EObject current=null] : (this_SYNONYM_SCALAR_RESTRICTION_TOKEN_0= RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY ) ;
    public final EObject ruleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token this_SYNONYM_SCALAR_RESTRICTION_TOKEN_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token otherlv_3=null;
        Token this_RCURLY_5=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4451:2: ( (this_SYNONYM_SCALAR_RESTRICTION_TOKEN_0= RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:4452:2: (this_SYNONYM_SCALAR_RESTRICTION_TOKEN_0= RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:4452:2: (this_SYNONYM_SCALAR_RESTRICTION_TOKEN_0= RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:4453:3: this_SYNONYM_SCALAR_RESTRICTION_TOKEN_0= RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY otherlv_3= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_5= RULE_RCURLY
            {
            this_SYNONYM_SCALAR_RESTRICTION_TOKEN_0=(Token)match(input,RULE_SYNONYM_SCALAR_RESTRICTION_TOKEN,FOLLOW_5); 

            			newLeafNode(this_SYNONYM_SCALAR_RESTRICTION_TOKEN_0, grammarAccess.getSynonymScalarRestrictionAccess().getSYNONYM_SCALAR_RESTRICTION_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:4457:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:4458:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:4458:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:4459:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_51); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getSynonymScalarRestrictionAccess().getLCURLYTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_3());
            		
            // InternalOntologicalModelingLanguage.g:4483:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:4484:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:4484:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:4485:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_5=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_5, grammarAccess.getSynonymScalarRestrictionAccess().getRCURLYTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSynonymScalarRestriction"


    // $ANTLR start "entryRuleTimeScalarRestriction"
    // InternalOntologicalModelingLanguage.g:4507:1: entryRuleTimeScalarRestriction returns [EObject current=null] : iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF ;
    public final EObject entryRuleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeScalarRestriction = null;


        try {
            // InternalOntologicalModelingLanguage.g:4507:62: (iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF )
            // InternalOntologicalModelingLanguage.g:4508:2: iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getTimeScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeScalarRestriction=ruleTimeScalarRestriction();

            state._fsp--;

             current =iv_ruleTimeScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeScalarRestriction"


    // $ANTLR start "ruleTimeScalarRestriction"
    // InternalOntologicalModelingLanguage.g:4514:1: ruleTimeScalarRestriction returns [EObject current=null] : (this_TIME_SCALAR_RESTRICTION_TOKEN_0= RULE_TIME_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY ) ;
    public final EObject ruleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token this_TIME_SCALAR_RESTRICTION_TOKEN_0=null;
        Token lv_name_1_0=null;
        Token this_LCURLY_2=null;
        Token otherlv_3=null;
        Token lv_minInclusive_4_0=null;
        Token otherlv_5=null;
        Token lv_maxInclusive_6_0=null;
        Token otherlv_7=null;
        Token lv_minExclusive_8_0=null;
        Token otherlv_9=null;
        Token lv_maxExclusive_10_0=null;
        Token otherlv_11=null;
        Token this_RCURLY_13=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4520:2: ( (this_TIME_SCALAR_RESTRICTION_TOKEN_0= RULE_TIME_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY ) )
            // InternalOntologicalModelingLanguage.g:4521:2: (this_TIME_SCALAR_RESTRICTION_TOKEN_0= RULE_TIME_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY )
            {
            // InternalOntologicalModelingLanguage.g:4521:2: (this_TIME_SCALAR_RESTRICTION_TOKEN_0= RULE_TIME_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY )
            // InternalOntologicalModelingLanguage.g:4522:3: this_TIME_SCALAR_RESTRICTION_TOKEN_0= RULE_TIME_SCALAR_RESTRICTION_TOKEN ( (lv_name_1_0= RULE_ID ) ) this_LCURLY_2= RULE_LCURLY (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )? (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )? (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )? (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )? otherlv_11= 'restrictedRange' ( ( ruleReference ) ) this_RCURLY_13= RULE_RCURLY
            {
            this_TIME_SCALAR_RESTRICTION_TOKEN_0=(Token)match(input,RULE_TIME_SCALAR_RESTRICTION_TOKEN,FOLLOW_5); 

            			newLeafNode(this_TIME_SCALAR_RESTRICTION_TOKEN_0, grammarAccess.getTimeScalarRestrictionAccess().getTIME_SCALAR_RESTRICTION_TOKENTerminalRuleCall_0());
            		
            // InternalOntologicalModelingLanguage.g:4526:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOntologicalModelingLanguage.g:4527:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOntologicalModelingLanguage.g:4527:4: (lv_name_1_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:4528:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"jpl.imce.oml.specification.OntologicalModelingLanguage.ID");
            				

            }


            }

            this_LCURLY_2=(Token)match(input,RULE_LCURLY,FOLLOW_70); 

            			newLeafNode(this_LCURLY_2, grammarAccess.getTimeScalarRestrictionAccess().getLCURLYTerminalRuleCall_2());
            		
            // InternalOntologicalModelingLanguage.g:4548:3: (otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==100) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4549:4: otherlv_3= 'minInclusive' ( (lv_minInclusive_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,100,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_3_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4553:4: ( (lv_minInclusive_4_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:4554:5: (lv_minInclusive_4_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:4554:5: (lv_minInclusive_4_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:4555:6: lv_minInclusive_4_0= RULE_STRING
                    {
                    lv_minInclusive_4_0=(Token)match(input,RULE_STRING,FOLLOW_71); 

                    						newLeafNode(lv_minInclusive_4_0, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minInclusive",
                    							lv_minInclusive_4_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4572:3: (otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==101) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4573:4: otherlv_5= 'maxInclusive' ( (lv_maxInclusive_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,101,FOLLOW_8); 

                    				newLeafNode(otherlv_5, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_4_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4577:4: ( (lv_maxInclusive_6_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:4578:5: (lv_maxInclusive_6_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:4578:5: (lv_maxInclusive_6_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:4579:6: lv_maxInclusive_6_0= RULE_STRING
                    {
                    lv_maxInclusive_6_0=(Token)match(input,RULE_STRING,FOLLOW_72); 

                    						newLeafNode(lv_maxInclusive_6_0, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"maxInclusive",
                    							lv_maxInclusive_6_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4596:3: (otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==102) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4597:4: otherlv_7= 'minExclusive' ( (lv_minExclusive_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,102,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_5_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4601:4: ( (lv_minExclusive_8_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:4602:5: (lv_minExclusive_8_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:4602:5: (lv_minExclusive_8_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:4603:6: lv_minExclusive_8_0= RULE_STRING
                    {
                    lv_minExclusive_8_0=(Token)match(input,RULE_STRING,FOLLOW_73); 

                    						newLeafNode(lv_minExclusive_8_0, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minExclusive",
                    							lv_minExclusive_8_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOntologicalModelingLanguage.g:4620:3: (otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==103) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4621:4: otherlv_9= 'maxExclusive' ( (lv_maxExclusive_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,103,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_6_0());
                    			
                    // InternalOntologicalModelingLanguage.g:4625:4: ( (lv_maxExclusive_10_0= RULE_STRING ) )
                    // InternalOntologicalModelingLanguage.g:4626:5: (lv_maxExclusive_10_0= RULE_STRING )
                    {
                    // InternalOntologicalModelingLanguage.g:4626:5: (lv_maxExclusive_10_0= RULE_STRING )
                    // InternalOntologicalModelingLanguage.g:4627:6: lv_maxExclusive_10_0= RULE_STRING
                    {
                    lv_maxExclusive_10_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

                    						newLeafNode(lv_maxExclusive_10_0, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"maxExclusive",
                    							lv_maxExclusive_10_0,
                    							"jpl.imce.oml.specification.OntologicalModelingLanguage.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_11, grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_7());
            		
            // InternalOntologicalModelingLanguage.g:4648:3: ( ( ruleReference ) )
            // InternalOntologicalModelingLanguage.g:4649:4: ( ruleReference )
            {
            // InternalOntologicalModelingLanguage.g:4649:4: ( ruleReference )
            // InternalOntologicalModelingLanguage.g:4650:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_8_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RCURLY_13=(Token)match(input,RULE_RCURLY,FOLLOW_2); 

            			newLeafNode(this_RCURLY_13, grammarAccess.getTimeScalarRestrictionAccess().getRCURLYTerminalRuleCall_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeScalarRestriction"


    // $ANTLR start "entryRuleReference"
    // InternalOntologicalModelingLanguage.g:4672:1: entryRuleReference returns [String current=null] : iv_ruleReference= ruleReference EOF ;
    public final String entryRuleReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReference = null;


        try {
            // InternalOntologicalModelingLanguage.g:4672:49: (iv_ruleReference= ruleReference EOF )
            // InternalOntologicalModelingLanguage.g:4673:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalOntologicalModelingLanguage.g:4679:1: ruleReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) ;
    public final AntlrDatatypeRuleToken ruleReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;
        AntlrDatatypeRuleToken this_QNAME_1 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4685:2: ( (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) )
            // InternalOntologicalModelingLanguage.g:4686:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            {
            // InternalOntologicalModelingLanguage.g:4686:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_IRI) ) {
                alt66=1;
            }
            else if ( (LA66_0==RULE_ID) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4687:3: this_IRI_0= RULE_IRI
                    {
                    this_IRI_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

                    			current.merge(this_IRI_0);
                    		

                    			newLeafNode(this_IRI_0, grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:4695:3: this_QNAME_1= ruleQNAME
                    {

                    			newCompositeNode(grammarAccess.getReferenceAccess().getQNAMEParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_QNAME_1=ruleQNAME();

                    state._fsp--;


                    			current.merge(this_QNAME_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleQNAME"
    // InternalOntologicalModelingLanguage.g:4709:1: entryRuleQNAME returns [String current=null] : iv_ruleQNAME= ruleQNAME EOF ;
    public final String entryRuleQNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQNAME = null;


        try {
            // InternalOntologicalModelingLanguage.g:4709:45: (iv_ruleQNAME= ruleQNAME EOF )
            // InternalOntologicalModelingLanguage.g:4710:2: iv_ruleQNAME= ruleQNAME EOF
            {
             newCompositeNode(grammarAccess.getQNAMERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQNAME=ruleQNAME();

            state._fsp--;

             current =iv_ruleQNAME.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQNAME"


    // $ANTLR start "ruleQNAME"
    // InternalOntologicalModelingLanguage.g:4716:1: ruleQNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABBREV_IRI_0= ruleABBREV_IRI | this_ValidID_1= ruleValidID ) ;
    public final AntlrDatatypeRuleToken ruleQNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ABBREV_IRI_0 = null;

        AntlrDatatypeRuleToken this_ValidID_1 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4722:2: ( (this_ABBREV_IRI_0= ruleABBREV_IRI | this_ValidID_1= ruleValidID ) )
            // InternalOntologicalModelingLanguage.g:4723:2: (this_ABBREV_IRI_0= ruleABBREV_IRI | this_ValidID_1= ruleValidID )
            {
            // InternalOntologicalModelingLanguage.g:4723:2: (this_ABBREV_IRI_0= ruleABBREV_IRI | this_ValidID_1= ruleValidID )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==EOF||(LA67_1>=RULE_IRI && LA67_1<=RULE_ANNOTATION_TOKEN)||LA67_1==RULE_RCURLY||(LA67_1>=RULE_ASPECT_TOKEN && LA67_1<=RULE_REIFIED_RELATIONSHIP_TOKEN)||(LA67_1>=RULE_TARGET_TOKEN && LA67_1<=RULE_STRUCTURE_TOKEN)||(LA67_1>=RULE_RANGE_TOKEN && LA67_1<=RULE_BINARY_SCALAR_RESTRICTION_TOKEN)||(LA67_1>=RULE_IRI_SCALAR_RESTRICTION_TOKEN && LA67_1<=RULE_TIME_SCALAR_RESTRICTION_TOKEN)||(LA67_1>=73 && LA67_1<=76)||LA67_1==79||LA67_1==82||LA67_1==84||(LA67_1>=86 && LA67_1<=87)||LA67_1==89||LA67_1==91||(LA67_1>=93 && LA67_1<=95)) ) {
                    alt67=2;
                }
                else if ( (LA67_1==107) ) {
                    alt67=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4724:3: this_ABBREV_IRI_0= ruleABBREV_IRI
                    {

                    			newCompositeNode(grammarAccess.getQNAMEAccess().getABBREV_IRIParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ABBREV_IRI_0=ruleABBREV_IRI();

                    state._fsp--;


                    			current.merge(this_ABBREV_IRI_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:4735:3: this_ValidID_1= ruleValidID
                    {

                    			newCompositeNode(grammarAccess.getQNAMEAccess().getValidIDParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValidID_1=ruleValidID();

                    state._fsp--;


                    			current.merge(this_ValidID_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQNAME"


    // $ANTLR start "entryRuleABBREV_IRI"
    // InternalOntologicalModelingLanguage.g:4749:1: entryRuleABBREV_IRI returns [String current=null] : iv_ruleABBREV_IRI= ruleABBREV_IRI EOF ;
    public final String entryRuleABBREV_IRI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleABBREV_IRI = null;


        try {
            // InternalOntologicalModelingLanguage.g:4749:50: (iv_ruleABBREV_IRI= ruleABBREV_IRI EOF )
            // InternalOntologicalModelingLanguage.g:4750:2: iv_ruleABBREV_IRI= ruleABBREV_IRI EOF
            {
             newCompositeNode(grammarAccess.getABBREV_IRIRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleABBREV_IRI=ruleABBREV_IRI();

            state._fsp--;

             current =iv_ruleABBREV_IRI.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleABBREV_IRI"


    // $ANTLR start "ruleABBREV_IRI"
    // InternalOntologicalModelingLanguage.g:4756:1: ruleABBREV_IRI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= ':' this_ValidID_2= ruleValidID ) ;
    public final AntlrDatatypeRuleToken ruleABBREV_IRI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4762:2: ( (this_ValidID_0= ruleValidID kw= ':' this_ValidID_2= ruleValidID ) )
            // InternalOntologicalModelingLanguage.g:4763:2: (this_ValidID_0= ruleValidID kw= ':' this_ValidID_2= ruleValidID )
            {
            // InternalOntologicalModelingLanguage.g:4763:2: (this_ValidID_0= ruleValidID kw= ':' this_ValidID_2= ruleValidID )
            // InternalOntologicalModelingLanguage.g:4764:3: this_ValidID_0= ruleValidID kw= ':' this_ValidID_2= ruleValidID
            {

            			newCompositeNode(grammarAccess.getABBREV_IRIAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_81);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            kw=(Token)match(input,107,FOLLOW_5); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getABBREV_IRIAccess().getColonKeyword_1());
            		

            			newCompositeNode(grammarAccess.getABBREV_IRIAccess().getValidIDParserRuleCall_2());
            		
            pushFollow(FOLLOW_2);
            this_ValidID_2=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_2);
            		

            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleABBREV_IRI"


    // $ANTLR start "entryRuleValidID"
    // InternalOntologicalModelingLanguage.g:4793:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalOntologicalModelingLanguage.g:4793:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalOntologicalModelingLanguage.g:4794:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalOntologicalModelingLanguage.g:4800:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4806:2: (this_ID_0= RULE_ID )
            // InternalOntologicalModelingLanguage.g:4807:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "ruleTerminologyGraphKind"
    // InternalOntologicalModelingLanguage.g:4817:1: ruleTerminologyGraphKind returns [Enumerator current=null] : ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) ;
    public final Enumerator ruleTerminologyGraphKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOntologicalModelingLanguage.g:4823:2: ( ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) )
            // InternalOntologicalModelingLanguage.g:4824:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            {
            // InternalOntologicalModelingLanguage.g:4824:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==108) ) {
                alt68=1;
            }
            else if ( (LA68_0==109) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalOntologicalModelingLanguage.g:4825:3: (enumLiteral_0= 'open' )
                    {
                    // InternalOntologicalModelingLanguage.g:4825:3: (enumLiteral_0= 'open' )
                    // InternalOntologicalModelingLanguage.g:4826:4: enumLiteral_0= 'open'
                    {
                    enumLiteral_0=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getTerminologyGraphKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTerminologyGraphKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOntologicalModelingLanguage.g:4833:3: (enumLiteral_1= 'closed' )
                    {
                    // InternalOntologicalModelingLanguage.g:4833:3: (enumLiteral_1= 'closed' )
                    // InternalOntologicalModelingLanguage.g:4834:4: enumLiteral_1= 'closed'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getTerminologyGraphKindAccess().getClosedWorldDesignationsEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTerminologyGraphKindAccess().getClosedWorldDesignationsEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyGraphKind"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L,0x0000300000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000300000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x1FEFDF038003E8C0L,0x0000000000001E00L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x1FEFDFF38003E8C0L,0x0000000000001E00L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000FFC0000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000FF80000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000000FF00000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000FE00000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000FC00000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000000F800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000000F000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000027FC0000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000027F80000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000027F00000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000027E00000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000027C00000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000027800000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000027000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000026000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000700400000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000600400000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000400400000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000F00400000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000E00400000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000C00400000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000800400000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x000000F000400000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x000000E000400000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x000000C000400000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000008000400000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000010F00400000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000010E00400000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000010C00400000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000010800400000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000010000400000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});

}