package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.StringUtil;
import seedu.address.model.login.Password;
import seedu.address.model.login.Username;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;


/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 * {@code ParserUtil} contains methods that take in {@code Optional} as parameters. However, it goes against Java's
 * convention (see https://stackoverflow.com/a/39005452) as {@code Optional} should only be used a return type.
 * Justification: The methods in concern receive {@code Optional} return values from other methods as parameters and
 * return {@code Optional} values based on whether the parameters were present. Therefore, it is redundant to unwrap the
 * initial {@code Optional} before passing to {@code ParserUtil} as a parameter and then re-wrap it into an
 * {@code Optional} return value inside {@code ParserUtil} methods.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_EVENT_INDEX = "Index is must be an integer greater than 0.";
    public static final String MESSAGE_INSUFFICIENT_PARTS = "Number of parts must be more than 1.";


    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws IllegalValueException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws IllegalValueException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new IllegalValueException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    //@@author ifalluphill
    /**
     * Parses {@code oneBasedIndex} into an {@code Int} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws IllegalValueException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static int parseCalendarDeleteIndex(String oneBasedIndex) throws IllegalValueException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new IllegalValueException(MESSAGE_INVALID_EVENT_INDEX);
        }
        return Integer.parseInt(trimmedIndex);
    }
    //@@author

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws IllegalValueException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new IllegalValueException(Name.MESSAGE_NAME_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code Optional<String> name} into an {@code Optional<Name>} if {@code name} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Name> parseName(Optional<String> name) throws IllegalValueException {
        requireNonNull(name);
        return name.isPresent() ? Optional.of(parseName(name.get())) : Optional.empty();
    }

    //@@author ifalluphill
    /**
     * Parses a {@code String eventName} into a {@code String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code eventName} is invalid.
     */
    public static String parseEventName(String name) throws IllegalValueException {
        requireNonNull(name);
        return name.trim();
    }

    /**
     * Parses a {@code String dateTime} into a {@code DateTime}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code eventName} is invalid.
     */
    public static String parseDateTime(String dateTime) throws IllegalValueException {
        requireNonNull(dateTime);
        return dateTime.trim();
    }

    /**
     * Parses a {@code String location} into a {@code String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code location} is invalid.
     */
    public static String parseLocation(String location) throws IllegalValueException {
        requireNonNull(location);
        return location.trim();
    }

    //@@author

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws IllegalValueException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new IllegalValueException(Phone.MESSAGE_PHONE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code Optional<String> phone} into an {@code Optional<Phone>} if {@code phone} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Phone> parsePhone(Optional<String> phone) throws IllegalValueException {
        requireNonNull(phone);
        return phone.isPresent() ? Optional.of(parsePhone(phone.get())) : Optional.empty();
    }


    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws IllegalValueException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(Address.MESSAGE_ADDRESS_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code Optional<String> address} into an {@code Optional<Address>} if {@code address} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Address> parseAddress(Optional<String> address) throws IllegalValueException {
        requireNonNull(address);
        return address.isPresent() ? Optional.of(parseAddress(address.get())) : Optional.empty();
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws IllegalValueException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new IllegalValueException(Email.MESSAGE_EMAIL_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code Optional<String> email} into an {@code Optional<Email>} if {@code email} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Email> parseEmail(Optional<String> email) throws IllegalValueException {
        requireNonNull(email);
        return email.isPresent() ? Optional.of(parseEmail(email.get())) : Optional.empty();
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws IllegalValueException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new IllegalValueException(Tag.MESSAGE_TAG_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws IllegalValueException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    //@@author jaronchan
    /**
     * Parses a {@code String feature}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code feature} is invalid.
     */
    public static String parseFeature(String feature) throws IllegalValueException {
        requireNonNull(feature);
        String trimmedFeature = feature.trim();
        if (!(trimmedFeature.equals("details")
                || trimmedFeature.equals("calendar")
                || trimmedFeature.equals("scheduler"))) {
            throw new IllegalValueException("Feature should only be either \"details\", \"calendar\" or \"scheduler\"");
        }
        return trimmedFeature;
    }

    //@@author kaisertanqr

    /**
     * Parses a {@code String username} into an {@code Username}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code username} is invalid.
     */
    public static Username parseUsername(String username) throws IllegalValueException {
        requireNonNull(username);
        String trimmedUsername = username.trim();
        if (!Username.isValidUsername(trimmedUsername)) {
            throw new IllegalValueException(Username.MESSAGE_USERNAME_CONSTRAINTS);
        }
        return new Username(trimmedUsername);
    }

    /**
     * Parses a {@code Optional<String> name} into an {@code Optional<Username>} if {@code name} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Username> parseUsername(Optional<String> username) throws IllegalValueException {
        requireNonNull(username);
        return username.isPresent() ? Optional.of(parseUsername(username.get().toLowerCase())) : Optional.empty();
    }

    /**
     * Parses a {@code String password} into an {@code Password}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalValueException if the given {@code password} is invalid.
     */
    public static Password parsePassword(String password) throws IllegalValueException {
        requireNonNull(password);
        String trimmedPassword = password.trim();
        if (!Password.isValidPassword(trimmedPassword)) {
            throw new IllegalValueException(Password.MESSAGE_PASSWORD_CONSTRAINTS);
        }
        return new Password(trimmedPassword);
    }

    /**
     * Parses a {@code Optional<String> password} into an {@code Optional<Password>} if {@code name} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Password> parsePassword(Optional<String> password) throws IllegalValueException {
        requireNonNull(password);
        return password.isPresent() ? Optional.of(parsePassword(password.get())) : Optional.empty();
    }
}
