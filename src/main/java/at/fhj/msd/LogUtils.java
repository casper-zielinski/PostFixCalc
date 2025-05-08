package at.fhj.msd;

import java.util.List;

import org.apache.logging.log4j.Logger;

/**
 * A utility class for consistent logging across the PostFixCalculator application.
 * Handles all logging operations with support for different log levels and contexts.
 * 
 * Key Features:
 * - Uses Object parameters for maximum flexibility with different data types
 * - Maintains clear separation between different logging contexts (calculation, conversion)
 * - Provides detailed debug info while keeping solution logs concise
 * - Formats tokens consistently with single quotes for better readability
 */
public class LogUtils {

    // ========================================================================
    // SECTION 1: General Purpose Logging Methods
    // (Used across all calculator operations)
    // ========================================================================

    /**
     * Logs when a token is identified as a non-operator.
     * @param logger The logger instance to use
     * @param token The token being processed (as Object to handle any type)
     */
    public static void noOperator(Logger logger, Object token) {
        logger.debug("token: '{}' is not an operator", token);
    }

    /**
     * Logs when a token is identified as an operator.
     * @param logger The logger instance to use
     * @param token The operator token (as Object to handle any type)
     */
    public static void isOperator(Logger logger, Object token) {
        logger.debug("token: '{}' is an operator", token);
    }

    /**
     * Logs when a digit token is processed.
     * @param logger The logger instance to use
     * @param token The digit token (as Object to handle any type)
     */
    public static void addDigit(Logger logger, Object token) {
        logger.debug("token: '{}' is a digit, adding to stack", token);
    }

    /**
     * Logs invalid tokens with error level.
     * @param logger The primary logger instance
     * @param solutionLogger The solution logger instance
     * @param token The invalid token (as Object to handle any type)
     */
    public static void invalidToken(Logger logger, Logger solutionLogger, Object token) {
        logger.error("token: '{}' is neither an operator nor a digit", token);
        solutionLogger.error("token: '{}' is neither an operator nor a digit", token);
    }

    // ========================================================================
    // SECTION 2: Stack Operations Logging
    // (Methods for tracking stack manipulations)
    // ========================================================================

    /**
     * Logs stack state changes.
     * @param logger The logger instance to use
     * @param stack The stack being logged
     * @param action Description of the stack operation
     */
    public static void stackUpdated(Logger logger, MySinglyLinkedList<String> stack, String action) {
        logger.debug("stack {}: {}", action, stack.printListAsString());
    }

    /**
     * Logs removal of an element from stack.
     * @param logger The logger instance to use
     * @param element The element being removed (as Object to handle any type)
     */
    public static void removingFromStack(Logger logger, Object element) {
        logger.debug("removing '{}' from stack", element);
    }

    /**
     * Logs addition of an element to stack.
     * @param logger The logger instance to use
     * @param element The element being added (as Object to handle any type)
     */
    public static void addingToStack(Logger logger, Object element) {
        logger.debug("adding '{}' to stack", element);
    }

    // ========================================================================
    // SECTION 3: List Operations Logging
    // (Methods for tracking list/operand manipulations)
    // ========================================================================

    /**
     * Logs list state changes.
     * @param logger The logger instance to use
     * @param list The list being logged
     * @param action Description of the list operation
     */
    public static void listUpdated(Logger logger, List<String> list, String action) {
        logger.debug("list {}: {}", action, list.toString());
    }

    /**
     * Logs addition of an element to list.
     * @param logger The logger instance to use
     * @param stack The stack from which element is taken
     */
    public static void addingToList(Logger logger, MySinglyLinkedList<String> stack) {
        logger.debug("adding element: '{}' to list", stack.first());
    }

    // ========================================================================
    // SECTION 4: Calculation-Specific Logging
    // (Methods used during postfix calculation)
    // ========================================================================

    /**
     * Logs start of calculation.
     * @param logger The primary logger instance
     * @param solutionLogger The solution logger instance
     * @param expression The expression being calculated
     */
    public static void StartCalculation(Logger logger, Logger solutionLogger, String expression) {
        logger.info("Start calculation for: {}", expression);
        solutionLogger.info("Start calculation for: {}", expression);
    }

    /**
     * Logs calculation operation.
     * @param logger The logger instance to use
     * @param number1 First operand (as Object to handle Double/String)
     * @param number2 Second operand (as Object to handle Double/String)
     * @param token The operator token
     */
    public static void calculatingFor(Logger logger, Object number1, Object number2, String token) {
        logger.info("Removed '{}' and '{}' from stack. Calculating: {} {} {}", 
                   number1, number2, number1, token, number2);
    }

    /**
     * Logs calculation result.
     * @param logger The logger instance to use
     * @param number1 First operand
     * @param number2 Second operand
     * @param token The operator token
     * @param result The calculation result
     */
    public static void calculated(Logger logger, double number1, double number2, String token, double result) {
        logger.info("Calculated result: {} {} {} = {}", number1, token, number2, result);
    }

    // ========================================================================
    // SECTION 5: Conversion Logging (Postfix to Infix)
    // ========================================================================

    /**
     * Logs start of postfix to infix conversion.
     * @param logger The primary logger instance
     * @param solutionLogger The solution logger instance
     * @param expression The expression being converted
     */
    public static void startConversionToInfix(Logger logger, Logger solutionLogger, String expression) {
        logger.info("Start conversion of PostFix to Infix for: {}", expression);
        solutionLogger.info("Start conversion of PostFix to Infix for: {}", expression);
    }

    /**
     * Logs conversion operation.
     * @param logger The logger instance to use
     * @param number1 First operand (as Object to handle Double/String)
     * @param number2 Second operand (as Object to handle Double/String)
     * @param token The operator token
     */
    public static void convertingFor(Logger logger, Object number1, Object number2, String token) {
        logger.info("Removed '{}' and '{}' from stack. Converting to infix: {} {} {}", 
                   number1, number2, number1, token, number2);
    }

    /**
     * Logs conversion result.
     * @param logger The logger instance to use
     * @param infix The resulting infix expression
     */
    public static void converted(Logger logger, String infix) {
        logger.info("Converted result: {}", infix);
    }

    // ========================================================================
    // SECTION 6: Conversion Logging (Infix to Postfix)
    // ========================================================================

    /**
     * Logs start of infix to postfix conversion.
     * @param logger The primary logger instance
     * @param solutionLogger The solution logger instance
     * @param expression The expression being converted
     */
    public static void startConversionToPostfix(Logger logger, Logger solutionLogger, String expression) {
        logger.info("Start conversion of Infix to PostFix for: {}", expression);
        solutionLogger.info("Start conversion of Infix to PostFix for: {}", expression);
    }

    // ========================================================================
    // SECTION 7: Error Handling & Utility Logging
    // ========================================================================

    /**
     * Logs division by zero error.
     * @param logger The primary logger instance
     * @param solutionLogger The solution logger instance
     */
    public static void divideByZero(Logger logger, Logger solutionLogger) {
        logger.error("Division by zero detected!");
        solutionLogger.error("Division by zero detected!");
        sectionBreak(logger, solutionLogger);
    }

    /**
     * Logs final result of an operation.
     * @param logger The primary logger instance
     * @param solutionLogger The solution logger instance
     * @param result The result to log (as Object to handle any type)
     */
    public static void finalResult(Logger logger, Logger solutionLogger, Object result) {
        logger.info("Final result: {}", result);
        solutionLogger.info("Final result: {}", result);
        sectionBreak(logger, solutionLogger);
    }

    /**
     * Inserts visual section break in logs.
     * @param logger The primary logger instance
     * @param solutionLogger The solution logger instance
     */
    public static void sectionBreak(Logger logger, Logger solutionLogger) {
        logger.debug("--------------------------------------------------");
        solutionLogger.debug("--------------------------------------------------");
    }
}